#!/bin/bash


#首先应该是传递过来一个版本号，然后在版本号前面加个before字样
bakpath="before$1"

#PLUGPATH="/root/lijian/plug"
#插件目录
PLUGPATH="/usr1/plug"


endBakPath="$PLUGPATH/$bakpath"



#定义上传插件到该服务器的目录，插件文件是要从这里取


PRODUCTPLUGTEMP="/usr1/productplugtemp/"

###要判断6个产品包和6个插件包是否都存在
cd $PRODUCTPLUGTEMP  && echo "进入目录${PRODUCTPLUGTEMP}查看文件是否存在:"  || exit 1

test ! -f "plugin_base.zip" && echo "plugin_base.zip文件不存在，退出"  &&  exit 1

test ! -f "plugin_bil.zip" && echo "plugin_bil.zip文件不存在，退出"   &&  exit 1

test ! -f "plugin_crm.zip" && echo "plugin_crm.zip文件不存在，退出"   &&  exit 1

test ! -f "plugin_report.zip" && echo "plugin_report.zip文件不存在，退出"   &&  exit 1

test ! -f "plugin_sos.zip" && echo "plugin_sos.zip文件不存在，退出"   &&  exit 1

test ! -f "plugin_task.zip" && echo "plugin_task.zip文件不存在，退出"   &&  exit 1

test ! -f "boss2-base.ear" && echo "boss2-base.ear文件不存在，退出"   &&  exit 1

test ! -f "boss2-bil.ear" && echo "boss2-bil.ear文件不存在，退出"   &&  exit 1

test ! -f "boss2-crm.ear" && echo "boss2-crm.ear文件不存在，退出"   && exit 1

test ! -f "boss2-report.ear" && echo "boss2-report.ear文件不存在，退出"   && exit 1

test ! -f "boss2-sos.ear" && echo "boss2-sos.ear文件不存在，退出"   && exit 1

test ! -f "boss2-task.ear" && echo "boss2-task.ear文件不存在，退出"   &&  exit 1

echo "12个文件都存在......"

#获取传递进来的上载版本号                                                                                                                  
#传递的输入参数无所谓空字符串，即，多打几个空格，这样会视为没有传递参数的，因此只要判断是否有参数传递即可                                  
if [ "$#" -lt 1 ] || [ "$#" -gt 1  ]; then                                                                                                 
        echo "ERROR，没输入版本号...."                                                                                                     
        exit 1                                                                                                                             
fi;



#为了可以重复发布同一版本，如果存在版本目录的话，就删除掉该版本目录                                                                        
test -d "$endBakPath" && echo "警告,${endBakPath}该备份版本文件目录存在，马上会删除"  && rm -rf "$endBakPath"  &&
echo "${endBakPath}该备份版本文件目录，删除成功"



echo "插件目录:$PLUGPATH"

mkdir $endBakPath   && echo "创建备份插件目录${endBakPath}成功"




#先跳转到插件目录
cd $PLUGPATH && echo "ok" || exit 1

#复制插件文件到刚刚创建的目录中
cp -r  plug_* $endBakPath                      && 

echo "备份插件文件到目录${endBakPath}成功"   && 


#然后删除所有的插件包
rm -rf plug_*                                  &&

echo "删除插件包成功"    &&

#创建新的插件目录
mkdir plug_base          &&   echo "创建插件目录plug_base"            || exit 1 
mkdir plug_bil           &&   echo "创建插件目录plug_bil"             || exit 1
mkdir plug_crm           &&   echo "创建插件目录plug_crm"             || exit 1
mkdir plug_report        &&   echo "创建插件目录plug_report"          || exit 1
mkdir plug_sos           &&   echo "创建插件目录plug_sos"             || exit 1
mkdir plug_task          &&   echo "创建插件目录plug_task"            || exit 1


#为了保证cp的正确性，我又一次进入插件的目录
cd $PLUGPATH   && echo "ok"  || exit 1

cp "${PRODUCTPLUGTEMP}plugin_base.zip" plug_base           &&  echo "复制文件${PRODUCTPLUGTEMP}plugin_base.zip到plug_base成功" || exit 1


cp "${PRODUCTPLUGTEMP}plugin_bil.zip" plug_bil            &&   echo "复制文件${PRODUCTPLUGTEMP}plugin_bil.zip到plug_bil成功"   || exit 1

cp "${PRODUCTPLUGTEMP}plugin_crm.zip" plug_crm            &&   echo "复制文件${PRODUCTPLUGTEMP}plugin_crm.zip到plug_crm成功"   || exit 1

cp "${PRODUCTPLUGTEMP}plugin_report.zip" plug_report      &&   echo "复制文件${PRODUCTPLUGTEMP}plugin_report.zip到plug_report成功" || exit 1

cp "${PRODUCTPLUGTEMP}plugin_sos.zip" plug_sos            &&   echo "复制文件${PRODUCTPLUGTEMP}plugin_sos.zip到plug_sos成功"       || exit 1

cp "${PRODUCTPLUGTEMP}plugin_task.zip" plug_task          &&    echo "复制文件${PRODUCTPLUGTEMP}plugin_task.zip到plug_task成功"    || exit 1


echo "插件部署成功!"


#####################################################产品包更新开始##############################################################
#关闭weblogic服务
echo "关闭weblogic服务"

ps aux|grep Dweblogic.Name=server1|grep -v grep |awk '{print $2}' | xargs kill -9

#关闭控制台服务
echo "关闭控制台服务"

ps aux|grep Dweblogic.Name=AdminServer|grep -v grep |awk '{print $2}' | xargs kill -9



echo "产品包更新开始"
#定义产品目录
PRODUCTDIR="/usr1/bea/upload/"

#然后cd到产品目录
cd $PRODUCTDIR            &&

#为了可以重复发布同一版本，如果存在版本目录的话，就删除掉该版本目录
test -d "$1" && echo "警告,该版本文件目录存在，马上会删除" && rm -rf "$1" || echo "该版本目录不存在"  


VERSIONNUM=$1

##首先要保证能进入到产品目录
cd $PRODUCTDIR         &&   echo "ok"  || exit 1
mkdir $VERSIONNUM      &&  echo "创建版本目录${VERSIONNUM}成功"  || exit 1

cd $VERSIONNUM        && echo "ok" || exit 1

#从上传的目录PRODUCTPLUGTEMP取产品文件 PRODUCTPLUGTEMP="/usr1/productplugtemp/"

cp "${PRODUCTPLUGTEMP}boss2-base.ear"  boss2-base.ear         && echo "复制产品包${PRODUCTPLUGTEMP}boss2-base.ear成功"           || exit 1

cp "${PRODUCTPLUGTEMP}boss2-bil.ear"  boss2-bil.ear           && echo "复制产品包${PRODUCTPLUGTEMP}boss2-bil.ear成功"            || exit 1

cp "${PRODUCTPLUGTEMP}boss2-crm.ear" boss2-crm.ear            && echo "复制产品包${PRODUCTPLUGTEMP}boss2-crm.ear成功"            || exit 1

cp "${PRODUCTPLUGTEMP}boss2-report.ear" boss2-report.ear      && echo "复制产品包${PRODUCTPLUGTEMP}boss2-report.ear成功"         || exit 1

cp "${PRODUCTPLUGTEMP}boss2-sos.ear"  boss2-sos.ear           && echo "复制产品包${PRODUCTPLUGTEMP}boss2-sos.ear成功"            || exit 1

cp "${PRODUCTPLUGTEMP}boss2-task.ear" boss2-task.ear          && echo "复制产品包${PRODUCTPLUGTEMP}boss2-task.ear成功"                || exit 1

#mod_all_w  这里就不错mod_all_w成功或者失败的检测了 由于mod_all_w是输出到控制台
mod_all_w ${VERSIONNUM} 17_W.conf

echo "暂停5秒针，看看是否mod_all_w成功，若不成功，可以Ctrl-C直接终止程序......"

##睡眠五秒，让看看是否有sucessful字样。。
sleep 5s



##然后在进入mod_all_w中的版本目录
cd $VERSIONNUM                     &&


#复制下面的6个产品包到父父文件夹
test -f "boss2-base.ear"        &&  echo "ok" || exit 1
test -f "boss2-bil.ear"         &&  echo "ok" || exit 1
test -f "boss2-crm.ear"         &&  echo "ok" || exit 1
test -f "boss2-report.ear"      &&  echo "ok" || exit 1
test -f "boss2-sos.ear"         &&  echo "ok" || exit 1
test -f "boss2-task.ear"        &&  echo "ok" || exit 1

cd ${PRODUCTDIR}  && echo "ok" || exit 1
rm -rf boss2-*   &&  echo "删除文件夹${PRODUCTDIR}内的boss2产品包成功" || exit 1

cd -

cp boss2-* ${PRODUCTDIR}    &&    echo "更新mod_all_w之后的产品包到${PRODUCTDIR}文件夹内成功"  || exit 1




#清理缓存


CACHEDIR="/usr1/bea/user_projects/domains/base_domain/servers/server1/"

cd $CACHEDIR

echo "清理缓存目录:${CACHEDIR}"

rm -rf tmp


rm -rf cache


#重启控制台
/usr1/bea/user_projects/domains/base_domain/bin/start


#重启应用
/usr1/bea/user_projects/domains/base_domain/bin/start1

#启动应用日志输出
tail  -f /usr1/bea/user_projects/domains/base_domain/bin/server1.log

 




