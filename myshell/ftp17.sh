#!/bin/bash
#  author: Jian Lee
############################################################
#
#
#      ��226���ع�������17
#
#
#
#############################################################


#  ftp �ļ�����   

#����Զ�̷�������·�� Ҳ������Ҫ���ĸ�·�������ļ�
#cd /root/lijian

#��������·����Ҳ���������ص��ļ������ĸ�·��
#lcd /home/oracle/lijian/myshelltest

#�ص�������ʾ

#prompt off

cd /usr1/productplugtemp
rm -rf boss2-* plugin_* && echo "ɾ��/usr1/productplugtemp�ڵĲ�Ʒ���Ͳ�����ɹ�" || exit 1


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

echo "226���ع�������17�����سɹ���"
