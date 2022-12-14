@BO @regresion @usuario @BUG_954 @BUG_847 @BUG_814
Feature: Usuarios

  Como usuario de Coopsol quiero acceder a "Usuarios"
  para poder realizar ABM

  #El nombre se genera de forma dinámica y queda concatenado al que se muestra en el example
  #La página no permite borrar el usuario
  #MM-821
  Scenario Outline: Creacion de usuario Exitosa
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Usuarios"
    When el admin selecciona "+ Nuevo Usuario"
    When el admin completa el formulario con "Nombre:" <Nombre>, "Contraseña:" <Pass> y "Roles:" <Rol>
    When Hago click en el boton "Guardar"
    Then el usuario se crea exitosamente con "Roles:" <Rol>

    Examples:
      | Nombre     | Pass     | Rol   |
      | Emiliano   | !@#!@#   | ADMIN |
      | Juan Perez | 23423424 | BASIC |


  #MM-823
  @Ignore
  Scenario Outline: Eliminacion de usuario con rol <rol>
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Usuarios"
    When el admin selecciona el primer usuario con rol <rol>
    When el admin hace click sobre el ícono "Eliminar", ubicado en "Acciones"
    When el admin hace click en "Aceptar"
    Then se muestra el mensaje "User eliminado exitosamente"
    And el usuario se elimina efectivamente

    Examples:
      | rol   |
      | Basic |
      | Admin |


  #MM-951
  @Ignore
  Scenario Outline: Creacion de usuario Fallida
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Usuarios"
    When el admin selecciona "+ Nuevo Usuario"
    When el admin completa el formulario con "Nombre:" <Nombre>, "Contraseña:" <Pass> y "Roles:" <Rol>
    Then se muestra mensaje de error de campo obligatorio.

    Examples:
      | Nombre   | Pass     | Rol   |
      |          |          |       |
      |          | asdasd   | Basic |
      |          | !@#!@#   | Admin |
      |          | 23423424 |       |
      | Emiliano |          | Basic |
      | !@#@#$%  |          | Admin |
      | 13133123 |          |       |
      |          |          | Basic |
      |          |          | Admin |


@Ignore #MM-825 #Revisar
  Scenario Outline: Utilizacion del paginador <posicion> exitosamente
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Usuarios"
    When el admin selecciona paginador <posicion>
    Then se muestra la pagina <posicion>.

    Examples:
      | posicion  |
      | Siguiente |
      | Anterior  |


@Ignore @BUG_814 #MM-1126
  Scenario: Editar Usuario
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Usuarios"
    When hago click en el boton "Editar"
    When edito los campos del formulario
    When hago click en el boton "Guardar"
    Then el sistema muestra un mensaje  'Usuario editado exitosamente'