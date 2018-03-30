
#        proxy_set_header        Host            $host;
#!/bin/sh
cd /data/svn/
rm -rf polyFinance-lgd
svn checkout svn://120.92.4.210/student/polyFinance/trunk/lgd/polyFinance-lgd

cd  /data/svn/polyFinance-lgd
mvn clean install -Dmaven.test.skip=true
echo "===>install core 成功 "

##service-common begain ===##
cd /data/services/polyFinance-lgd/polyFinance-service-common/run/
rm -rf /data/services/polyFinance-lgd/polyFinance-service-common/backups/polyFinance-service-common.tar.gz
cp polyFinance-service-common.tar.gz /data/services/polyFinance-lgd/polyFinance-service-common/backups
rm -rf polyFinance-service-common.tar.gz classes lib

cd /data/svn/polyFinance-lgd/polyFinance-service-common/
mvn clean install -Dmaven.test.skip=true assembly:assembly
cd /data/svn/polyFinance-lgd/polyFinance-service-common/target

mv polyFinance-service-common.tar.gz /data/services/polyFinance-lgd/polyFinance-service-common/run
cd /data/services/polyFinance-lgd/polyFinance-service-common/run
tar -zxvf polyFinance-service-common.tar.gz
echo "===>mv service-common tag.z  成功 "
##service-common end ===##



##service-public begain ===##
cd /data/services/polyFinance-lgd/polyFinance-service-public/run/
rm -rf /data/services/polyFinance-lgd/polyFinance-service-public/backups/polyFinance-service-public.tar.gz
cp polyFinance-service-public.tar.gz /data/services/polyFinance-lgd/polyFinance-service-public/backups
rm -rf polyFinance-service-public.tar.gz classes lib

cd /data/svn/polyFinance-lgd/polyFinance-service-public/
mvn clean install -Dmaven.test.skip=true assembly:assembly
cd /data/svn/polyFinance-lgd/polyFinance-service-public/target

mv polyFinance-service-public.tar.gz /data/services/polyFinance-lgd/polyFinance-service-public/run
cd /data/services/polyFinance-lgd/polyFinance-service-public/run
tar -zxvf polyFinance-service-public.tar.gz
echo "===>mv service-public tag.z  成功 "
##service-public end ===##


##service-business begain ===##
cd /data/services/polyFinance-lgd/polyFinance-service-business/run/
rm -rf /data/services/polyFinance-lgd/polyFinance-service-business/backups/polyFinance-service-business.tar.gz
cp polyFinance-service-business.tar.gz /data/services/polyFinance-lgd/polyFinance-service-business/backups
rm -rf polyFinance-service-business.tar.gz classes lib

cd /data/svn/polyFinance-lgd/polyFinance-service-business/
mvn clean install -Dmaven.test.skip=true assembly:assembly
cd /data/svn/polyFinance-lgd/polyFinance-service-business/target

mv polyFinance-service-business.tar.gz /data/services/polyFinance-lgd/polyFinance-service-business/run
cd /data/services/polyFinance-lgd/polyFinance-service-business/run
tar -zxvf polyFinance-service-business.tar.gz

echo "===>mv service-business tag.z 成功 "
##service-business end ===##


##service-quartz begain ===##
cd /data/services/polyFinance-lgd/polyFinance-service-quartz/run/
rm -rf /data/services/polyFinance-lgd/polyFinance-service-quartz/backups/polyFinance-service-quartz.tar.gz
cp polyFinance-service-quartz.tar.gz /data/services/polyFinance-lgd/polyFinance-service-quartz/backups
rm -rf polyFinance-service-quartz.tar.gz classes lib

cd /data/svn/polyFinance-lgd/polyFinance-service-quartz/
mvn clean install -Dmaven.test.skip=true assembly:assembly
cd /data/svn/polyFinance-lgd/polyFinance-service-quartz/target

mv polyFinance-service-quartz.tar.gz /data/services/polyFinance-lgd/polyFinance-service-quartz/run
cd /data/services/polyFinance-lgd/polyFinance-service-quartz/run
tar -zxvf polyFinance-service-quartz.tar.gz

echo "===>mv service-quartz tag.z 成功"
##service-quartz end ===##

##web-admin begin ===##
echo "====>备份并清除旧文件web-admin"
rm /data/webs/polyFinance-lgd-web-admin/backups/polyFinance-web-admin.war
cp /data/webs/polyFinance-lgd-web-admin/run/polyFinance-web-admin.war /data/webs/polyFinance-lgd-web-admin/backups/polyFinance-web-admin.war
rm -rf /data/webs/polyFinance-lgd-web-admin/run/*
mv /data/svn/polyFinance-lgd/polyFinance-web-admin/target/polyFinance-web-admin.war /data/webs/polyFinance-lgd-web-admin/run/polyFinance-web-admin.war
echo "====>开始解压polyFinance-web-admin.war"
cd /data/webs/polyFinance-lgd-web-admin/run/
jar -xvf polyFinance-web-admin.war
echo "====>解压完成"
##web-admin end ===#

##web-admin begin ===##
echo "====>备份清除旧文件web-home"
rm /data/webs/polyFinance-lgd-web-home/backups/polyFinance-web-home.war
cp /data/webs/polyFinance-lgd-web-home/run/polyFinance-web-home.war /data/webs/polyFinance-lgd-web-home/backups/polyFinance-web-home.war
rm -rf /data/webs/polyFinance-lgd-web-home/run/*
mv /data/svn/polyFinance-lgd/polyFinance-web-home/target/polyFinance-web-home.war /data/webs/polyFinance-lgd-web-home/run/polyFinance-web-home.war
echo "====>开始解压polyFinance-web-home.war"
cd /data/webs/polyFinance-lgd-web-home/run/
jar -xvf polyFinance-web-home.war
echo "====>解压完成"
##web-admin end ===##
