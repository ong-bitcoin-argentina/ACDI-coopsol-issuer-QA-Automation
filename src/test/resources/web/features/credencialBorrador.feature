@BO @regresion @credenciales

Feature: Como usuario de Coopsol quiero poder crear una nueva credencial

  Scenario: Caso fallido de creación de una nueva credencial por campo NOMBRE vacio

    Given que el admin esta logueado en la web de coopsol.
    When hago click en el boton "+ Crear nueva credencial"
    And relleno los campos requeridos de "DID", "APELLIDO", “ACTIVIDAD PRINCIPAL” con informacion valida
    And hago click en el boton Guardar
    Then el campo NOMBRE  muesta el mensaje de error  "Requerido"
