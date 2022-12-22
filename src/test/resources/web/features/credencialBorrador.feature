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
  @Giuliana
  Scenario Outline: Caso fallido de creación de una nueva credencial por campo NOMBRE vacio
    Given que el admin esta logueado en la web de coopsol.
    When el admin hace click en  "+ Crear nueva credencial"
    And relleno los campos requeridos de <DID>,<NOMBRE>,<APELLIDO>,<ACTIVIDAD PRINCIPAL> con informacion valida
    And el admin hace click en "Guardar"
    Then el campo vacio muesta el mensaje de error  "Requerido"
    Examples:
      | DID                                                 | NOMBRE   | APELLIDO   | ACTIVIDAD PRINCIPAL |
      | did:ethr:0x843bc178821fgc4e62c3b262a97d39fh3b9b6658 |          | Castellini | Productiva RSK      |
      | did:ethr:0x843bc178821fgc4e62c3b262a97d39fh3b9b6658 | Giuliana |            | Productiva RSK      |
      |                                                     | Giuliana | Castellini | Productiva RSK      |
      |                                                     |          |            | Productiva RSK      |

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