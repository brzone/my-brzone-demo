#!/bin/bash

#  这个是跑用户数据的，对应的存储过程为：STA_SERV_PROD_PROC
#  没传时间，就取默认的时间为sysdate-1
#  日志文件为：/usr1/run/CRM/update_sta_serv_prod.log
#  如果日志文件超过100M，自动会清除
#  date:2012-12-27 14:20

#crontab不会自动加载环境变量，这里手动加载环境变量
. /etc/profile

#一定的加上绝对路径，然后会生成到用户的home路径
logFileName="/usr1/run/CRM/update_sta_serv_prod".log

logStartTime=`date +'%Y-%m-%d %H:%m:%S'`


echo '[Next]'  >> $logFileName

#如果日志文件超过100M，则清空日志文件                                                                                                      
len=`ls -l $logFileName | awk '{print $5}'`                                                                                                
test "$len" -gt 100000000 &&  echo '[Next]' > $logFileName 

echo "##################################"  >> $logFileName

echo "[logStartTime]:${logStartTime}" >> $logFileName

#连接地址，如：boss_crm/boss_crm@180.200.3.17/boss   
conn_args=$(grep '^CRM='  /usr/lib/lines/O2_CRM.ini |cut -d "=" -f 2)

#传的日期是当前日期减去一天
vtime=`date +"%Y-%m-%d" -d'-1 day'`


#如果外界传递进来参数，这里的话，就必须只传递1个参数，时间，时间格式为YYYY-MM-DD，没有传递的话，就取当前时间减一天
test "$#" == "1" && vtime=$1 

sqlplus -S $conn_args >> "$logFileName" << EOF

        exec sta_serv_prod_proc('$vtime');

exit 

EOF

logEndTime=`date +'%Y-%m-%d %H:%m:%S'`

echo "[logEndTime:]${logEndTime}" >> $logFileName

echo "##################################"  >> $logFileName

exit 0
