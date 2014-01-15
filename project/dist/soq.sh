#!/bin/bash
 
file="$1"
sudo /etc/init.d/soq stop
sudo mkdir -p ~/soq
sudo rm -rf ~/soq/current
if [ "$file" == "" ]; then 
   echo "you must specify the .zip file name"
else
  noExt="${file%.*}"
  echo "$noExt"
  sudo rm -rf ~/soq/"$noExt"
   sudo gunzip $file -d ~/soq/
   sudo mv ~/soqsoq/"$noExt" ~/soq/current
fi