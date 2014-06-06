#!/bin/bash

#  ��������û����ݵģ���Ӧ�Ĵ洢����Ϊ��STA_SERV_PROD_PROC
#  û��ʱ�䣬��ȡĬ�ϵ�ʱ��Ϊsysdate-1
#  ��־�ļ�Ϊ��/usr1/run/CRM/update_sta_serv_prod.log
#  �����־�ļ�����100M���Զ������
#  date:2012-12-27 14:20

#crontab�����Զ����ػ��������������ֶ����ػ�������
. /etc/profile

#һ���ļ��Ͼ���·����Ȼ������ɵ��û���home·��
logFileName="/usr1/run/CRM/update_sta_serv_prod".log

logStartTime=`date +'%Y-%m-%d %H:%m:%S'`


echo '[Next]'  >> $logFileName

#�����־�ļ�����100M���������־�ļ�                                                                                                      
len=`ls -l $logFileName | awk '{print $5}'`                                                                                                
test "$len" -gt 100000000 &&  echo '[Next]' > $logFileName 

echo "##################################"  >> $logFileName

echo "[logStartTime]:${logStartTime}" >> $logFileName

#���ӵ�ַ���磺boss_crm/boss_crm@180.200.3.17/boss   
conn_args=$(grep '^CRM='  /usr/lib/lines/O2_CRM.ini |cut -d "=" -f 2)

#���������ǵ�ǰ���ڼ�ȥһ��
vtime=`date +"%Y-%m-%d" -d'-1 day'`


#�����紫�ݽ�������������Ļ����ͱ���ֻ����1��������ʱ�䣬ʱ���ʽΪYYYY-MM-DD��û�д��ݵĻ�����ȡ��ǰʱ���һ��
test "$#" == "1" && vtime=$1 

sqlplus -S $conn_args >> "$logFileName" << EOF

        exec sta_serv_prod_proc('$vtime');

exit 

EOF

logEndTime=`date +'%Y-%m-%d %H:%m:%S'`

echo "[logEndTime:]${logEndTime}" >> $logFileName

echo "##################################"  >> $logFileName

exit 0
