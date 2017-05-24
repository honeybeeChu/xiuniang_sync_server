
. $HOME/.bash_profile

###timeLenCard aaa, dayFullSyn
WORK_HOME="/lcims/datasync"
DATA_DIR=$WORK_HOME/wxserver
SRC_DB="-Uuseradmin -Puseradmin -STEST_JKUSER_SERVER"
DST_DB="-Uuseradmin -Puseradmin -SYPT_JKUSER_SERVER"

SRC_DB_NAME=USERDB
DST_DB_NAME=USERDB

tables="D_ENTERPRISE_REGISTER,D_QRCODE_GROUP"

delTableData(){
table=$1
ret=`isql $DST_DB <<!
delete from $table
go
exit
!`
}

for table in `echo $tables|sed 's/,/ /g'`
do
    echo "----------------------"
    echo "***`date +%Y%m%d-%H:%M:%S` bcp out $table ***"
    bcp $table out $DATA_DIR/$table.tmp ${SRC_DB} -Jiso_1 -c -b 500
    echo "*** export $table OK ***"

    echo "*** delTableData: $table ***"
    delTableData $table

    echo "***`date +%Y%m%d-%H:%M:%S` bcp in $table ***"
    bcp $table in $DATA_DIR/$table.tmp ${DST_DB} -Jiso_1 -c -b 500
    echo "*** import $table OK ***"

    sleep 1
done

