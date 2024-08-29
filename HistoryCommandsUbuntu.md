# History commands terminal ununtu 
## №1
mkdir gb   
cd ~/gb    
cat > home_animals    
cat > pack_animals    
cat home_animals pack_animals > animals    
cat animals    
mv animals human_friends    
ls -ali
## №2
cd ..    
mkdir gb1   
cd ~/gb  
mv himan_friends ~/gb1  
cd ~/gb1   
ls -ali   
## №3
sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb    
sudo dpkg -i mysql-apt-config_0.8.23-1_all.deb    
sudo apt-get update    
sudo apt-get install mysql-server
## №4
sudo wget http://archive.ubuntu.com/ubuntu/pool/main/a/adduser/adduser_3.137ubuntu1_all.deb   
sudo dpkg -i adduser_3.137ubuntu1_all.deb    
sudo dpkg  -r --force-all adduser  