# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = "2"

DITA_OT_VERSION = "2.0"

$script = <<SCRIPT
sudo apt-get update
sudo apt-get install -y openjdk-7-jdk git ant
sudo update-java-alternatives --set java-1.7.0-openjdk-amd64
git clone https://github.com/dita-ot/dita-ot.git
sudo chown -R vagrant:vagrant dita-ot
cd dita-ot
ant
SCRIPT

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "hashicorp/precise64"
  config.vm.provision "shell", inline: $script
end
