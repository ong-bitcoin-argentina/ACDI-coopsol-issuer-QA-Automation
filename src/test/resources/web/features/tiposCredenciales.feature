@BO @regresion @credenciales @smoke @BUG_963 @BUG_1125
Feature: Templates Tipos de Credenciales

  Como usuario de Coopsol Issuer
  Quiero acceder a los Tipos de credenciales

  ##El nombre se genera de forma dinámica y queda concatenado al que se muestra en el example
  @BUG_1125 #MM-856
  Scenario Outline: crear un "Nuevo Template"
    Given que el admin esta logueado en la web de coopsol.
    When  el admin selecciona "Tipos de credenciales"
    And  el admin da click en el boton "Nuevo Template"
    And  el admin completa el Nombre <Nombre> y Emisor <Emisor>
    Then se muestran un mensaje de "Template creado exitosamente"

    Examples:
      | Nombre | Emisor      |
      | Test01 | Coopsol RSK |
      | Test02 | Coopsol     |

  #MM-831
  Scenario: Eliminar un Template
    Given que el admin esta logueado en la web de coopsol.
    And el admin tiene tipos de credenciales
    When el admin selecciona "Tipos de credenciales"
    And el admin hace clic en "Eliminar" un tipo de credencial
    And el admin hace clic en aceptar
    Then se muestran un mensaje de "Template eliminado exitosamente"

    #MM-832
  Scenario: Caso exitoso Editar un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Tipos de credenciales"
    And el admin selecciona el boton "Editar" al costado derecho del template del primer resultado.
    Then se abre una sección para editar la información del template


    ##MM-833
  Scenario Outline: Editar una categoria de credencial de un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Tipos de credenciales"
    And el admin selecciona el boton "Editar" al costado derecho del template del primer resultado.
    And el admin hace click en la categoria de la credencial
    And el admin elige la Categoria <Categoria>
    And el admin da click en "Guardar"
    Then se muestran un mensaje de "Template actualizado exitosamente"

    Examples:
      | Categoria  |
      | EDUCACIÓN  |
      | FINANZAS   |
      | VIVIENDA   |
      | IDENTIDAD  |
      | BENEFICIOS |
      | LABORAL    |


        ##MM-835
  Scenario Outline: Editar datos del participante de una credencial de un Template
    Given el admin esta logueado en la web de coopsol
    When el admin selecciona el área "Tipos de credenciales"
    And el admin selecciona el boton "Editar" al costado derecho del template
    And el admin se dirige a la sección de "Datos del participante"
    And edita el campo DID <DID>, Nombre <NOMBRE>, Apellido <APELLIDO> y Expiracion date <EXPIRACION DATE>
    And el admin da click en "Guardar"
    Then se muestra un mensaje de "Template actualizado exitosamente"

    Examples:
      | DID                  |  NOMBRE     | APELLIDO   |  EXPIRACION DATE   |
      | 12316464114164       | Jesus       | Vasquez    |  01/07/2022        |


      ##MM-835
    Scenario Outline: Editar datos de una credencial de un Template
    Given el admin esta logueado en la web de coopsol
    When el admin selecciona el area "Tipos de credenciales"
    And el admin selecciona el boton "Editar" al costado derecho del template
    And el admin se dirigue a la seccion de "Datos de la credencial"
    And edita el campo "CREDENCIAL" ingresando un dato <Datos>
    And el admin da click en "Guardar"
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
    Given el admin esta logueado en la web de coopsol
    When el admin selecciona el area "Tipos de credenciales"
    And el admin selecciona el boton "Editar" al costado derecho del template
    And el admin se dirigue a la seccion de "Datos de la credencial"
    And da click en el boton "Nuevo Campo"
    And completa los campos Nombre <NOMBRE> y Tipo <TIPO>
    And el admin da click en "Crear"
    Then se crea un nuevo campo para editar un template

    Examples:
      | NOMBRE      | TIPO        |
      | Jesus       | Text        |
      | dadaaddd    | Paragraph   |
      | 12345       | Date        |
      | Ivana       | Number      |
      | Emiliano    | Boolean     |
      | Ejemplo     | Checkbox    |


 @Ignore #MM-1127
 Scenario: Editar template con valores vacíos fallido
   Given que el admin esta logueado en la web de coopsol.
   When el admin selecciona "Tipo de Credenciales"
   When hago click en el boton “Editar"
   When dejo vacio los campos tildados como "Requeridos"
   When hago click en el boton "Guardar"
   Then el sistema no permite realizar los cambios