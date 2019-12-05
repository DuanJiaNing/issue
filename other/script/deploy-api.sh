NAME=issue-api-1.0-SNAPSHOT.jar
echo $NAME
ID=`ps -ef | grep "$NAME" | grep -v "grep" | awk '{print $2}'`
echo $ID
echo "---------------"
for id in $ID
do
	kill -9 $id
	echo "killed $id"
done
echo "prepare to deploy $NAME after 10s..."

sleep 10s
java -jar /usr/duan/jenkins/issue/jar/issue-api-1.0-SNAPSHOT.jar > /usr/duan/jenkins/issue/log/api.log 2>&1 &

echo excute success from deploy-api.sh
