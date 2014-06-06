#!/bin/bash

#跑营业收费
#一个分公司一个分公司放在后台跑，并行运行
#没传时间的话，默认当前时间sysdate-1，是下一个shell确定的
#传时间，必须要传俩个，开始时间和结束时间
#data: 2012-12-26 14:18


for city in 0 1 10 2 3 4 5 6 7 8 9 A B C D E


do

        if [ "$#" ==  "2" ]; then

            
             sh /usr1/run/CRM/update_sta_biz_fee_proc_onecity.sh $city $1 $2  &

        else
            sh /usr1/run/CRM/update_sta_biz_fee_proc_onecity.sh $city &
        fi;
done


exit 0
