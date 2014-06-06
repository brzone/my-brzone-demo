#!/bin/bash

#  这个是跑营业收费，对应的存储过程为：STA_BIZ_FEE_PROC
#  没传时间，就取默认的时间sysdate-1=stime=etime
#  但是必须要传分公司，因为这里是跑一个分公司
#  一个分公司一个日志文件，如：分公司A，日志文件为：/usr1/run/CRM/update_sta_biz_fee_procA.log
#  如果日志文件超过100M，自动会清除
#  date:2012-12-26 14:20

#crontab不会自动加载环境变量，这里手动加载
. /etc/profile

test $# -lt 1 && echo " arguest must be have city "   && exit 1


#一定的加上绝对路径，然后会生成到用户的home路径
logFileName="/usr1/run/CRM/update_sta_biz_fee_proc$1".log

logStartTime=`date +'%Y-%m-%d %H:%m:%S'`

echo '[Next]'  >> $logFileName

#如果日志文件超过100M，则清空日志文件                                                                                                      
len=`ls -l $logFileName | awk '{print $5}'`                                                                                                
test "$len" -gt 100000000 &&  echo '[Next]' > $logFileName 

echo "##################################"  >> $logFileName

echo "[logStartTime]:${logStartTime}" >> $logFileName

#连接地址，如：boss_crm/boss_crm@180.200.3.17/boss   
conn_args=$(grep '^CRM='  /usr/lib/lines/O2_CRM.ini |cut -d "=" -f 2)

#开始时间
#传的日期是当前日期减去一天
stime=`date +"%Y-%m-%d" -d'-1 day'`

#截止时间
etime=`date +"%Y-%m-%d" -d'-1 day'`

#如果外界传递进来参数，这里的话，就必须只传递3个参数，分公司 开始时间 结束时间,不然的话，就取当前时间减一天
test "$#" == "3" && stime=$2 && etime=$3

sqlplus -S $conn_args >> "$logFileName" << EOF

        exec sta_biz_fee_proc('$1','$stime','$etime');

exit 

EOF

logEndTime=`date +'%Y-%m-%d %H:%m:%S'`

echo "[logEndTime:]${logEndTime}" >> $logFileName

echo "##################################"  >> $logFileName

exit 0
