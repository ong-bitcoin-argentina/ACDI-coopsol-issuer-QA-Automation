@BO @regresion @smoke @configuracion

Feature: Como usuario de Coopsol quiero cambiar contraseña desde la web

  #MM-922
  Scenario: Caso exitoso cambiar contraseña
    Given que el admin esta logueado en la web de coopsol.
    When hago click en la pestaña 'Configuración'
    And hago click en el campo Nueva contraseña y completo con 'Crowdar387!!'
    And hago click en el campo Confirmar nueva contraseña y completo con 'Crowdar387!!'
    And hago click en el boton 'Actualizar contraseña'
    Then el sistema muestra un mensaje  'Contraseña actualizada con éxito'

    # Revierto el cambio de contraseña
    And hago click en el campo Nueva contraseña y completo con 'default'
    And hago click en el campo Confirmar nueva contraseña y completo con 'default'
    And hago click en el boton 'Actualizar contraseña'
    Then el sistema muestra un mensaje  'Contraseña actualizada con éxito'