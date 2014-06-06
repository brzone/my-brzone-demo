#!/bin/bash

#  �������Ӫҵ�շѣ���Ӧ�Ĵ洢����Ϊ��STA_BIZ_FEE_PROC
#  û��ʱ�䣬��ȡĬ�ϵ�ʱ��sysdate-1=stime=etime
#  ���Ǳ���Ҫ���ֹ�˾����Ϊ��������һ���ֹ�˾
#  һ���ֹ�˾һ����־�ļ����磺�ֹ�˾A����־�ļ�Ϊ��/usr1/run/CRM/update_sta_biz_fee_procA.log
#  �����־�ļ�����100M���Զ������
#  date:2012-12-26 14:20

#crontab�����Զ����ػ��������������ֶ�����
. /etc/profile

test $# -lt 1 && echo " arguest must be have city "   && exit 1


#һ���ļ��Ͼ���·����Ȼ������ɵ��û���home·��
logFileName="/usr1/run/CRM/update_sta_biz_fee_proc$1".log

logStartTime=`date +'%Y-%m-%d %H:%m:%S'`

echo '[Next]'  >> $logFileName

#�����־�ļ�����100M���������־�ļ�                                                                                                      
len=`ls -l $logFileName | awk '{print $5}'`                                                                                                
test "$len" -gt 100000000 &&  echo '[Next]' > $logFileName 

echo "##################################"  >> $logFileName

echo "[logStartTime]:${logStartTime}" >> $logFileName

#���ӵ�ַ���磺boss_crm/boss_crm@180.200.3.17/boss   
conn_args=$(grep '^CRM='  /usr/lib/lines/O2_CRM.ini |cut -d "=" -f 2)

#��ʼʱ��
#���������ǵ�ǰ���ڼ�ȥһ��
stime=`date +"%Y-%m-%d" -d'-1 day'`

#��ֹʱ��
etime=`date +"%Y-%m-%d" -d'-1 day'`

#�����紫�ݽ�������������Ļ����ͱ���ֻ����3���������ֹ�˾ ��ʼʱ�� ����ʱ��,��Ȼ�Ļ�����ȡ��ǰʱ���һ��
test "$#" == "3" && stime=$2 && etime=$3

sqlplus -S $conn_args >> "$logFileName" << EOF

        exec sta_biz_fee_proc('$1','$stime','$etime');

exit 

EOF

logEndTime=`date +'%Y-%m-%d %H:%m:%S'`

echo "[logEndTime:]${logEndTime}" >> $logFileName

echo "##################################"  >> $logFileName

exit 0
