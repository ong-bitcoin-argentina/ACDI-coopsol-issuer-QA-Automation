@BO @regresion @credenciales

Feature: Como usuario de Coopsol quiero poder crear una nueva credencial

#MM-826
  Scenario: Caso exitoso de creacion de una nueva credencial
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Credenciales"
    When hago click en el boton "+ Crear nueva credencial"
    And relleno los campos con informacion valida
    When hago click en el boton "Guardar"
    Then se genera una nueva credencial y se logra visualizar en la lista de credenciales pendientes

#MM-842  #MM-843 #MM-841 #MM-840
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
