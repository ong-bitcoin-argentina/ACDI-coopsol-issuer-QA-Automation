@BO @regresion @smoke @configuracion @BUG_960

Feature: Como usuario de Coopsol quiero cambiar contraseña desde la web

  #MM-922
  Scenario: Caso exitoso cambiar contraseña
    Given que el admin esta logueado en la web de coopsol.
    When hago click en la pestaña 'Configuración'
    And hago click en el campo Nueva contraseña y completo con 'Crowdar387!!'
    And hago click en el campo Confirmar nueva contraseña y completo con 'Crowdar387!!'
    And hago click en el boton 'Actualizar contraseña'
    Then el sistema muestra un mensaje 'Contraseña actualizada con éxito'
    # Revierto el cambio de contraseña
    When hago click en el campo Nueva contraseña y completo con 'default'
    And hago click en el campo Confirmar nueva contraseña y completo con 'default'
    And hago click en el boton 'Actualizar contraseña'
    Then el sistema muestra un mensaje 'Contraseña actualizada con éxito'


  @BUG_960
    @Ignore
  Scenario: Fallido al intentar cambiar pass con valores vacíos
    Given que el admin esta logueado en la web de coopsol.


    #borrar si escribio damian este test case
  @Ignore @BUG_960 #MM-923
  Scenario: Caso fallido cambiar contraseña con campo “nueva contraseña” vacio
    Given estoy logueado en la web de coopsol con el usuario "crowdar" y password "Crowdar387!"
    When hago clck en la pestaña "Configuracion"
    And hago click en el campo “Contraseña anterior" y completo con campos validos
    And hago click en el campo “Nueva contraseña" y dejo el campo vacio
    And hago click en el campo “Confirmar nueva contraseña" y completo con campos validos
    And hago click en el boton “Actualizar contraseña”
    Then el sistema muestra un mensaje “Las contraseña debe tener 6 caracteres como mínimo”


  #MM-924
  Scenario: Caso fallido cambiar contraseña - contaseñas no coinciden
    Given que el admin esta logueado en la web de coopsol.
    When hago click en la pestaña 'Configuración'
    And hago click en el campo Nueva contraseña y completo con 'Crowdar000!'
    And hago click en el campo Confirmar nueva contraseña y completo con 'Crowdar!!'
    Then el sistema muestra un mensaje 'Las contraseñas no coinciden'