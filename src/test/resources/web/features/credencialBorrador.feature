@BO @regresion @credenciales

Feature: Como usuario de Coopsol quiero poder crear una nueva credencial

#MM-826
  Scenario: Caso exitoso de creacion de una nueva credencial
    Given estoy logueado en la web de coopsol con el usuario "crowdar" y password "Crowdar387!"
    When hago clck en el boton "Crear nueva credencial"
    And relleno los campos con informacion valida
    And hago clikc en el boton "Guardar"
    Then se genera una nueva credencial y se logra visualizar en la lista de credenciales pendientes

#MM-842
  Scenario: Caso fallido de creación de una nueva credencial por campo NOMBRE vacio
    Given que el admin esta logueado en la web de coopsol.
    When hago click en el boton "+ Crear nueva credencial"
    And relleno los campos requeridos de "DID", "APELLIDO", “ACTIVIDAD PRINCIPAL” con informacion valida
    And hago click en el boton Guardar
    Then el campo NOMBRE  muesta el mensaje de error  "Requerido"


    #MM-843
  Scenario: Caso fallido de creación de una nueva credencial por campo APELLIDO vacio
    Given estoy logueado en la web de coopsol con el usuario "crowdar" y password "Crowdar387!"
    When hago clck en el boton "Crear nueva credencial"
    And relleno los campos requeridos de "DID", "NOMBRE"
    And hago click en el boton Guardar
    Then el campo APELLIDO muesta el mensaje de error  "Requerido"

    #MM-841
  Scenario: Caso fallido de creación de una nueva credencial por campo DID vacio
    Given estoy logueado en la web de coopsol con el usuario "crowdar" y password "Crowdar387!"
    When hago click en la sección “Credenciales”
    And hago cilck en el boton "Crear nueva credencial"
    And relleno los campos requeridos de "NOMBRE", "APELLIDO", “ACTIVIDAD PRINCIPAL”
    And hago click en el boton Guardar
    Then el campo DID muesta el mensaje de error  "Requerido"

 #MM-840
  Scenario: Caso fallido de creación de una nueva credencial por campos requeridos vacios
    Given estoy logueado en la web de coopsol con el usuario "crowdar" y password "Crowdar387!"
    When hago click en la sección “Credenciales”
    And hago click en el boton "Crear nueva credencial"
    And hago click en el boton Guardar sin completar los campos
    Then los campos requeridos muestran el mensaje de error "Requerido"