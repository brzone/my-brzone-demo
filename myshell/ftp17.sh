#!/bin/bash
#  author: Jian Lee
############################################################
#
#
#      从226下载构建包到17
#
#
#
#############################################################


#  ftp 文件下载   

#跳到远程服务器的路径 也就是你要从哪个路径下载文件
#cd /root/lijian

#跳到本地路径，也就是你下载的文件放在哪个路径
#lcd /home/oracle/lijian/myshelltest

#关掉下载提示

#prompt off

cd /usr1/productplugtemp
rm -rf boss2-* plugin_* && echo "删除/usr1/productplugtemp内的产品包和插件包成功" || exit 1


ftp -n << EOF

open 180.200.3.226


user root 123456

binary

cd /usr1/bea/uploadfiels/hudson

lcd /usr1/productplugtemp

prompt

mget boss2-*

mget plugin_*

close

bye

EOF

echo "226下载构建包到17，下载成功！"
