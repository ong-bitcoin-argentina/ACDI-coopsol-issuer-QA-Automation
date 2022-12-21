@BO @regresion @productores @BUG_948
Feature: Productores
  Como usuario de Coopsol
  Quiero acceder a "Productores"

#MM-844
  @smoke
  Scenario: Caso exitoso de registro de un nuevo productors
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Productores"
    When hago click en el boton "+Nuevo Productor"
    When relleno los campos del formulario “Apellido”, “Nombre”, “DNI”, “Email”, “Número_de_teléfono”, “CUIT”, “DID”
    When hago click en el boton "Guardar"
    Then se muestran un mensaje de "Productor creado exitosamente"

#MM-873
  @smoke
  Scenario: Caso exitoso editar un productor
    Given que el admin esta logueado en la web de coopsol.
    And haber registrado un productor con anterioridad
    When el admin selecciona "Productores"
    And hago click en el boton “Editar"
    And edito el formulario del productor con informacion válida
    And hago click en el boton "Guardar"
    Then se edita exitosamente en la lista de productores

#MM-934
  Scenario: Caso fallido de registro de un nuevo productor
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Productores"
    When hago click en el boton "+Nuevo Productor"
    When relleno el formulario de productor con campos vacios
    When hago click en el boton "Guardar"
    Then no se genera un nuevo productor

  @BUG_948 #MM-875
  Scenario: Caso fallido al editar un productor sin completar campos
    Given que el admin esta logueado en la web de coopsol.
    And haber registrado un productor con anterioridad
    When el admin selecciona "Productores"
    When me posiciono sobre un productor
    When hago click en el boton “Editar"
    When edito el formulario del productor dejando los campos vacios
    When hago click en el boton "Guardar"
    Then el sistema muestra un mensaje de “ERROR” con los campos requeridos

