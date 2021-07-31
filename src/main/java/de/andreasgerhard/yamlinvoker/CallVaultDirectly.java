package de.andreasgerhard.yamlinvoker;

import de.andreasgerhard.vault.module.Vault;
import de.andreasgerhard.vault.policy.Password;
import de.andreasgerhard.vault.policy.Permission;

public class CallVaultDirectly {

  public static void main(String[] args) {
    new Vault().host("http://localhost:8200")
        .init()
        .engine("kv", "/secret")
        .application()
          .name("test-application")
        .appRole().enable().create()
          .passwordPolicy("default", Password.STANDARD)
          .profile("live")
          .secret().key("key1").value("some-secret1").create()
          .secret().key("key2").value("some-secret2").create()
          .secret().key("key3").value("some-secret3").create()
          .acl()
          .suffix("acl").applicationPermission(
        Permission.CREATE, Permission.DELETE, Permission.LIST, Permission.READ).publish();
  }
}
