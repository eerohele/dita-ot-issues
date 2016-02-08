# -*- mode: ruby -*-
# vi: set ft=ruby :

if ENV["DITA_GIT"].nil? || !Dir.exists?(ENV["DITA_GIT"])
    abort <<EOS
DITA_GIT environment variable not set.

Set the DITA_GIT environment variable to point to your clone of the DITA-OT Git
repository at https://github.com/dita-ot/dita-ot.git.
EOS
end

Vagrant.configure(2) do |config|
  config.vm.define "linux" do |linux|
    linux.vm.box = "minimal/trusty64"

    linux.vm.synced_folder ENV["DITA_GIT"], "/opt/dita-ot",
      owner: "vagrant", group: "vagrant"

    linux.vm.provision "ansible" do |ansible|
      ansible.playbook = "playbooks/ubuntu.yml"
    end

    linux.vm.provider "virtualbox" do |v|
      v.memory = 1024
    end
  end

  config.vm.define "windows" do |windows|
    windows.vm.box = "opentable/win-2012r2-standard-amd64-nocm"

    windows.vm.synced_folder ENV["DITA_GIT"], "c:/dita-ot"

    windows.vm.provision "shell", inline: "iex ((new-object net.webclient).DownloadString('https://chocolatey.org/install.ps1'))"
    windows.vm.provision "shell", inline: "choco install -y jdk8"
    windows.vm.provision "shell", inline: "choco install -y ant"
    windows.vm.provision "shell", inline: <<EOS
setx /m DITA_GIT "c:/dita-ot"

if ((Get-Command "dita" -ErrorAction SilentlyContinue) -eq $null) {
   setx /m PATH "%PATH%;%DITA_GIT%/src/main/bin"
}
EOS
  end
end
