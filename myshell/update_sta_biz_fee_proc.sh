#!/bin/bash

#��Ӫҵ�շ�
#һ���ֹ�˾һ���ֹ�˾���ں�̨�ܣ���������
#û��ʱ��Ļ���Ĭ�ϵ�ǰʱ��sysdate-1������һ��shellȷ����
#��ʱ�䣬����Ҫ����������ʼʱ��ͽ���ʱ��
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
