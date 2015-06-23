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
  config.vm.box = "ubuntu/vivid64"

  config.vm.synced_folder ENV["DITA_GIT"], "/opt/dita-ot",
    owner: "vagrant", group: "vagrant"

  config.vm.provision "ansible" do |ansible|
    ansible.playbook = "playbook.yml"
  end
end
