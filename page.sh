#!/bin/bash
# chkconfig: 2345 10 90
# description: this is a gui for ute tool
# processname: utetool


maxBoder=90
TITLE="System For DTC Tool"
print_line(){
	for ((i=0;i<$maxBoder;i++));
	do
	   echo -n "-";
	done
}

body=("  Welcome To DTC Tool System" \
"1.Start Job (compare 1 syndb 2 report 4)" \
"2.Stop " \
"3.Status" \
"4.Quit")

print_sort(){
	for i in {1..2}
	do
	  echo -e "\n"
	done
}
print_body(){
	num=${#body[@]}
	echo ""
	for ((i=0;i<num;i++)) ; 
	  do 
	    for j in {1..20}
	    do
		echo -n " "
	    done
	  echo -n -e $"${body[i]} \n"
	  done
	

}

QUIT=0

while [ $QUIT = 0 ]
do	
	clear
	print_line
       # echo $" the body title--?${body[0]}"
	echo ""
	print_body
       	print_sort

	echo "Please Input The Order Key ..."

        read key
        if [ $key = '1' ] ; then 
	  echo "your choose start"
        elif [ $key = '2' ] ;then
          echo "your choose stop " 
	elif [ $key = '3' ] ; then
          echo "your choose status "
        elif [ $key = '4' ] ; then 
          echo "Thanks,Bye"
	  QUIT=10
        else
           echo " Please check you inpu " 
        fi

	sleep 2






done   

