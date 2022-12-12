@BO @regresion @smoke @productores
Feature: Productores

  Como usuario de Coopsol
  Quiero acceder a "Productores"

##MM-844
  Scenario: Caso exitoso de registro de un nuevo productors
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Productores"
    When hago click en el boton "+Nuevo Productor"
    When relleno los campos del formulario “Apellido”, “Nombre”, “DNI”, “Email”, “Número_de_teléfono”, “CUIT”, “DID”
    When hago click en el boton "Guardar"
    Then se muestran un mensaje de "Productor creado exitosamente"

    #MM-873

  Scenario: Caso exitoso editar un productor

    Given que el admin esta logueado en la web de coopsol.
    And haber registrado un productor con anterioridad
    When el admin selecciona "Productores"
    And hago click en el boton “Editar"
    And edito el formulario del productor con informacion válida
    And hago click en el boton "Guardar"
    Then se edita exitosamente en la lista de productores
