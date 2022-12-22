@BO @regresion @credenciales @smoke @BUG_963 @BUG_1125
Feature: Templates Tipos de Credenciales

  Como usuario de Coopsol Issuer
  Quiero acceder a los Tipos de credenciales

  ##El nombre se genera de forma dinámica y queda concatenado al que se muestra en el example
  @BUG_1125 #MM-856
  Scenario Outline: crear un "Nuevo Template"
    Given que el admin esta logueado en la web de coopsol.
    When  el admin selecciona "Tipos de credenciales"
    When  el admin da click en el boton "Nuevo Template"
    When  el admin completa el Nombre <Nombre> y Emisor <Emisor>
    Then se muestran un mensaje de "Template creado exitosamente"

    Examples:
      | Nombre | Emisor      |
      | Test01 | Coopsol RSK |
      | Test02 | Coopsol     |

  #MM-831
  Scenario: Eliminar un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin tiene tipos de credenciales
    When el admin selecciona "Tipos de credenciales"
    When el admin hace clic en "Eliminar" un tipo de credencial
    When el admin hace clic en aceptar
    Then se muestran un mensaje de "Template eliminado exitosamente"

    #MM-832
  Scenario Outline: Caso exitoso Editar un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Tipos de credenciales"
    When hago click en el boton “Editar"
    When se abre una sección para editar la información del template
    When el admin se dirige a la sección de "Datos del participante"
    When edita el campo DID <DID>, Nombre <NOMBRE>, Apellido <APELLIDO> y Expiracion date <EXPIRACION DATE>
    When el admin da click en "Guardar"
    Then se muestra un mensaje de "Template actualizado exitosamente"

    Examples:
      | DID                  |  NOMBRE     | APELLIDO   |  EXPIRACION DATE   |
      | 12316464114164       | Jesus       | Vasquez    |  01/07/2022        |


    ##MM-833
  Scenario Outline: Editar una categoria de credencial de un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Tipos de credenciales"
    When hago click en el boton “Editar"
    When el admin hace click en la categoria de la credencial
    When el admin elige la Categoria <Categoria>
    When el admin da click en "Guardar"
    Then se muestran un mensaje de "Template actualizado exitosamente"

    Examples:
      | Categoria  |
      | EDUCACIÓN  |
      | FINANZAS   |
      | VIVIENDA   |
      | IDENTIDAD  |
      | BENEFICIOS |
      | LABORAL    |


  @Ignore      ##MM-835 se junta con el gherkin de la 832
  Scenario Outline: Editar datos del participante de una credencial de un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Tipos de credenciales"
    And el admin selecciona el boton "Editar" al costado derecho del template
    And el admin se dirige a la sección de "Datos del participante"
    And edita el campo DID <DID>, Nombre <NOMBRE>, Apellido <APELLIDO> y Expiracion date <EXPIRACION DATE>
    And el admin da click en "Guardar"
    Then se muestra un mensaje de "Template actualizado exitosamente"

    Examples:
      | DID                  |  NOMBRE     | APELLIDO   |  EXPIRACION DATE   |
      | 12316464114164       | Jesus       | Vasquez    |  01/07/2022        |


      ##MM-834
  Scenario Outline: Editar datos de una credencial de un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Tipos de credenciales"
    When hago click en el boton “Editar"
    When el admin se dirigue a la seccion de "Datos de la credencial"
    When edita el campo "CREDENCIAL" ingresando un dato <Datos>
    When el admin da click en "Guardar"
    Then se muestra un mensaje de "Template actualizado exitosamente"

    Examples:
      | Datos                |
      | Identitaria coopsol  |
      | loco                 |
      | asddadada            |
      | 12456325             |
      |                      |
      | %#$&%&#&#            |


       ##MM-836
  Scenario Outline: Crear un nuevo campo para editar en un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Tipos de credenciales"
    When hago click en el boton “Editar"
    When el admin se dirigue a la seccion de "Datos de la credencial"
    When da click en el boton "Nuevo Campo"
    When completa los campos Nombre <NOMBRE> y Tipo <TIPO>
    When el admin da click en "Crear"
    Then se crea un nuevo campo para editar un template

    Examples:
      | NOMBRE      | TIPO        |
      | Jesus       | Text        |
      | dadaaddd    | Paragraph   |
      | 12345       | Date        |
      | Ivana       | Number      |
      | Emiliano    | Boolean     |
      | Ejemplo     | Checkbox    |