@BO @regresion @smoke @productores
Feature: Como usuario de Coopsol quiero editar un Productor


  Scenario: Caso exitoso editar un productor

    Given estoy logueado en la web de coopsol con el usuario “User_Admin"
    And haber registrado un productor con anterioridad
    When hago click en la pestaña "Productores"
    And hago click en el boton “Editar"
    And edito el formulario del productor con informacion válida
    And hago click en el boton "Guardar"
    Then se edita exitosamente en la lista de productores
