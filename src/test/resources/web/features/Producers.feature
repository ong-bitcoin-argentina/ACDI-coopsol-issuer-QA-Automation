@BO @regresion @smoke @productores
Feature: Productores

  Como usuario de Coopsol
  Quiero acceder a "Productores"

##MM-844
  Scenario: Caso exitoso de registro de un nuevo productor

    Given estoy logueado en la web de coopsol con el usuario “User_Admin"
    When hago click en la pestaña "Productores"
    When hago click en el boton "+Nuevo Productor"
    When relleno los campos del formulario “Apellido”, “Nombre”, “DNI”, “Email”, “Número_de_teléfono”, “CUIT”, “DID”
    When hago click en el boton "Guardar"
    Then se genera exitosamente un nuevo registro en la lista de productores desplegandose un pop up con la leyenda “Productor Creado Exitosamente”

    #MM-873
  @prueba
  Scenario: Caso exitoso editar un productor

    Given estoy logueado en la web de coopsol con el usuario “User_Admin"
    And haber registrado un productor con anterioridad
    When hago click en la pestaña "Productores"
    And hago click en el boton “Editar"
    And edito el formulario del productor con informacion válida
    And hago click en el boton "Guardar"
    Then se edita exitosamente en la lista de productores