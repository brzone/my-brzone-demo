#!/bin/bash


#����Ӧ���Ǵ��ݹ���һ���汾�ţ�Ȼ���ڰ汾��ǰ��Ӹ�before����
bakpath="before$1"

#PLUGPATH="/root/lijian/plug"
#���Ŀ¼
PLUGPATH="/usr1/plug"


endBakPath="$PLUGPATH/$bakpath"



#�����ϴ�������÷�������Ŀ¼������ļ���Ҫ������ȡ


PRODUCTPLUGTEMP="/usr1/productplugtemp/"

###Ҫ�ж�6����Ʒ����6��������Ƿ񶼴���
cd $PRODUCTPLUGTEMP  && echo "����Ŀ¼${PRODUCTPLUGTEMP}�鿴�ļ��Ƿ����:"  || exit 1

test ! -f "plugin_base.zip" && echo "plugin_base.zip�ļ������ڣ��˳�"  &&  exit 1

test ! -f "plugin_bil.zip" && echo "plugin_bil.zip�ļ������ڣ��˳�"   &&  exit 1

test ! -f "plugin_crm.zip" && echo "plugin_crm.zip�ļ������ڣ��˳�"   &&  exit 1

test ! -f "plugin_report.zip" && echo "plugin_report.zip�ļ������ڣ��˳�"   &&  exit 1

test ! -f "plugin_sos.zip" && echo "plugin_sos.zip�ļ������ڣ��˳�"   &&  exit 1

test ! -f "plugin_task.zip" && echo "plugin_task.zip�ļ������ڣ��˳�"   &&  exit 1

test ! -f "boss2-base.ear" && echo "boss2-base.ear�ļ������ڣ��˳�"   &&  exit 1

test ! -f "boss2-bil.ear" && echo "boss2-bil.ear�ļ������ڣ��˳�"   &&  exit 1

test ! -f "boss2-crm.ear" && echo "boss2-crm.ear�ļ������ڣ��˳�"   && exit 1

test ! -f "boss2-report.ear" && echo "boss2-report.ear�ļ������ڣ��˳�"   && exit 1

test ! -f "boss2-sos.ear" && echo "boss2-sos.ear�ļ������ڣ��˳�"   && exit 1

test ! -f "boss2-task.ear" && echo "boss2-task.ear�ļ������ڣ��˳�"   &&  exit 1

echo "12���ļ�������......"

#��ȡ���ݽ��������ذ汾��                                                                                                                  
#���ݵ������������ν���ַ�����������򼸸��ո���������Ϊû�д��ݲ����ģ����ֻҪ�ж��Ƿ��в������ݼ���                                  
if [ "$#" -lt 1 ] || [ "$#" -gt 1  ]; then                                                                                                 
        echo "ERROR��û����汾��...."                                                                                                     
        exit 1                                                                                                                             
fi;



#Ϊ�˿����ظ�����ͬһ�汾��������ڰ汾Ŀ¼�Ļ�����ɾ�����ð汾Ŀ¼                                                                        
test -d "$endBakPath" && echo "����,${endBakPath}�ñ��ݰ汾�ļ�Ŀ¼���ڣ����ϻ�ɾ��"  && rm -rf "$endBakPath"  &&
echo "${endBakPath}�ñ��ݰ汾�ļ�Ŀ¼��ɾ���ɹ�"



echo "���Ŀ¼:$PLUGPATH"

mkdir $endBakPath   && echo "�������ݲ��Ŀ¼${endBakPath}�ɹ�"




#����ת�����Ŀ¼
cd $PLUGPATH && echo "ok" || exit 1

#���Ʋ���ļ����ոմ�����Ŀ¼��
cp -r  plug_* $endBakPath                      && 

echo "���ݲ���ļ���Ŀ¼${endBakPath}�ɹ�"   && 


#Ȼ��ɾ�����еĲ����
rm -rf plug_*                                  &&

echo "ɾ��������ɹ�"    &&

#�����µĲ��Ŀ¼
mkdir plug_base          &&   echo "�������Ŀ¼plug_base"            || exit 1 
mkdir plug_bil           &&   echo "�������Ŀ¼plug_bil"             || exit 1
mkdir plug_crm           &&   echo "�������Ŀ¼plug_crm"             || exit 1
mkdir plug_report        &&   echo "�������Ŀ¼plug_report"          || exit 1
mkdir plug_sos           &&   echo "�������Ŀ¼plug_sos"             || exit 1
mkdir plug_task          &&   echo "�������Ŀ¼plug_task"            || exit 1


#Ϊ�˱�֤cp����ȷ�ԣ�����һ�ν�������Ŀ¼
cd $PLUGPATH   && echo "ok"  || exit 1

cp "${PRODUCTPLUGTEMP}plugin_base.zip" plug_base           &&  echo "�����ļ�${PRODUCTPLUGTEMP}plugin_base.zip��plug_base�ɹ�" || exit 1


cp "${PRODUCTPLUGTEMP}plugin_bil.zip" plug_bil            &&   echo "�����ļ�${PRODUCTPLUGTEMP}plugin_bil.zip��plug_bil�ɹ�"   || exit 1

cp "${PRODUCTPLUGTEMP}plugin_crm.zip" plug_crm            &&   echo "�����ļ�${PRODUCTPLUGTEMP}plugin_crm.zip��plug_crm�ɹ�"   || exit 1

cp "${PRODUCTPLUGTEMP}plugin_report.zip" plug_report      &&   echo "�����ļ�${PRODUCTPLUGTEMP}plugin_report.zip��plug_report�ɹ�" || exit 1

cp "${PRODUCTPLUGTEMP}plugin_sos.zip" plug_sos            &&   echo "�����ļ�${PRODUCTPLUGTEMP}plugin_sos.zip��plug_sos�ɹ�"       || exit 1

cp "${PRODUCTPLUGTEMP}plugin_task.zip" plug_task          &&    echo "�����ļ�${PRODUCTPLUGTEMP}plugin_task.zip��plug_task�ɹ�"    || exit 1


echo "�������ɹ�!"


#####################################################��Ʒ�����¿�ʼ##############################################################
#�ر�weblogic����
echo "�ر�weblogic����"

ps aux|grep Dweblogic.Name=server1|grep -v grep |awk '{print $2}' | xargs kill -9

#�رտ���̨����
echo "�رտ���̨����"

ps aux|grep Dweblogic.Name=AdminServer|grep -v grep |awk '{print $2}' | xargs kill -9



echo "��Ʒ�����¿�ʼ"
#�����ƷĿ¼
PRODUCTDIR="/usr1/bea/upload/"

#Ȼ��cd����ƷĿ¼
cd $PRODUCTDIR            &&

#Ϊ�˿����ظ�����ͬһ�汾��������ڰ汾Ŀ¼�Ļ�����ɾ�����ð汾Ŀ¼
test -d "$1" && echo "����,�ð汾�ļ�Ŀ¼���ڣ����ϻ�ɾ��" && rm -rf "$1" || echo "�ð汾Ŀ¼������"  


VERSIONNUM=$1

##����Ҫ��֤�ܽ��뵽��ƷĿ¼
cd $PRODUCTDIR         &&   echo "ok"  || exit 1
mkdir $VERSIONNUM      &&  echo "�����汾Ŀ¼${VERSIONNUM}�ɹ�"  || exit 1

cd $VERSIONNUM        && echo "ok" || exit 1

#���ϴ���Ŀ¼PRODUCTPLUGTEMPȡ��Ʒ�ļ� PRODUCTPLUGTEMP="/usr1/productplugtemp/"

cp "${PRODUCTPLUGTEMP}boss2-base.ear"  boss2-base.ear         && echo "���Ʋ�Ʒ��${PRODUCTPLUGTEMP}boss2-base.ear�ɹ�"           || exit 1

cp "${PRODUCTPLUGTEMP}boss2-bil.ear"  boss2-bil.ear           && echo "���Ʋ�Ʒ��${PRODUCTPLUGTEMP}boss2-bil.ear�ɹ�"            || exit 1

cp "${PRODUCTPLUGTEMP}boss2-crm.ear" boss2-crm.ear            && echo "���Ʋ�Ʒ��${PRODUCTPLUGTEMP}boss2-crm.ear�ɹ�"            || exit 1

cp "${PRODUCTPLUGTEMP}boss2-report.ear" boss2-report.ear      && echo "���Ʋ�Ʒ��${PRODUCTPLUGTEMP}boss2-report.ear�ɹ�"         || exit 1

cp "${PRODUCTPLUGTEMP}boss2-sos.ear"  boss2-sos.ear           && echo "���Ʋ�Ʒ��${PRODUCTPLUGTEMP}boss2-sos.ear�ɹ�"            || exit 1

cp "${PRODUCTPLUGTEMP}boss2-task.ear" boss2-task.ear          && echo "���Ʋ�Ʒ��${PRODUCTPLUGTEMP}boss2-task.ear�ɹ�"                || exit 1

#mod_all_w  ����Ͳ���mod_all_w�ɹ�����ʧ�ܵļ���� ����mod_all_w�����������̨
mod_all_w ${VERSIONNUM} 17_W.conf

echo "��ͣ5���룬�����Ƿ�mod_all_w�ɹ��������ɹ�������Ctrl-Cֱ����ֹ����......"

##˯�����룬�ÿ����Ƿ���sucessful��������
sleep 5s



##Ȼ���ڽ���mod_all_w�еİ汾Ŀ¼
cd $VERSIONNUM                     &&


#���������6����Ʒ���������ļ���
test -f "boss2-base.ear"        &&  echo "ok" || exit 1
test -f "boss2-bil.ear"         &&  echo "ok" || exit 1
test -f "boss2-crm.ear"         &&  echo "ok" || exit 1
test -f "boss2-report.ear"      &&  echo "ok" || exit 1
test -f "boss2-sos.ear"         &&  echo "ok" || exit 1
test -f "boss2-task.ear"        &&  echo "ok" || exit 1

cd ${PRODUCTDIR}  && echo "ok" || exit 1
rm -rf boss2-*   &&  echo "ɾ���ļ���${PRODUCTDIR}�ڵ�boss2��Ʒ���ɹ�" || exit 1

cd -

cp boss2-* ${PRODUCTDIR}    &&    echo "����mod_all_w֮��Ĳ�Ʒ����${PRODUCTDIR}�ļ����ڳɹ�"  || exit 1




#������


CACHEDIR="/usr1/bea/user_projects/domains/base_domain/servers/server1/"

cd $CACHEDIR

echo "������Ŀ¼:${CACHEDIR}"

rm -rf tmp


rm -rf cache


#��������̨
/usr1/bea/user_projects/domains/base_domain/bin/start


#����Ӧ��
/usr1/bea/user_projects/domains/base_domain/bin/start1

#����Ӧ����־���
tail  -f /usr1/bea/user_projects/domains/base_domain/bin/server1.log

 




