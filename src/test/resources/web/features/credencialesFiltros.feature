@BO @regresion @smoke @credenciales @BUG_946
Feature: Credenciales - Filtros
  Como usuario de Coopsol
  quiero acceder a credenciales en uso para poder
  REVOCARLAS segun FILTRO aplicado

  @BUG_946
    #MM-815
  Scenario Outline: Filtros de busqueda Exitoso
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Credenciales"
    When el admin selecciona "Credenciales en uso"
    When el admin completa el filtro "Tipo:" <Tipo>, "Nombre:" <Nombre>, "Apellido:" <Apellido>, "Desde:" <Desde>, "Hasta:" <Hasta>
    Then se muestran los resultados de acuerdo al criterio de busqueda

    Examples:
      | Tipo           | Nombre | Apellido | Desde      | Hasta      |
      | Productiva RSK | David  | Morelos  | 08/08/2022 | 08/08/2022 |
      |                | David  | Morelos  | 08/08/2022 | 08/08/2022 |
      |                |        | Morelos  | 08/08/2022 | 08/08/2022 |
      |                |        |          | 08/08/2022 | 08/08/2022 |
      |                |        |          |            | 08/08/2022 |
      | Productiva RSK | David  | Morelos  |            |            |
      | Productiva RSK | David  |          |            |            |
      | Productiva RSK |        |          |            |            |
      |                | David  |          |            |            |
      |                |        | Morelos  |            |            |
      |                |        |          | 08/08/2022 |            |
      | Productiva RSK | David  |          | 08/08/2022 |            |
      | Productiva RSK |        | Morelos  |            | 08/08/2022 |


    @Ignore  #MM-945
  Scenario Outline: Filtros de busqueda fallidos
    Given el admin esta logueado en la web de coopsol
    When el admin selecciona "Credenciales en uso"
    When  el admin completa el filtro "Tipo" con <Tipo>, "Nombre" con <Nombre>, "Apellido" con <Apellido>, "Desde" con <Desde>, "Hasta" con <Hasta>
    Then  se muestra alerta de campos invalidos.

    Examples:
      | Tipo         | Nombre   | Apellido | Desde      | Hasta      |
      |              | 234234   | 234234   | sdfsdf     | sdfsdf     |
      |              | !!!!!    | ##%##    | @%#%#      | #$##       |
      | Crowdar-Test | Emiliano | 234234   | @%#%#      |            |
      | Crowdar-Test | 234234   | ##%##    |            | 29/07/2022 |
      | Crowdar-Test |          | Palacio  | sdfsdf     | #$##       |
      |              | 234234   |          | sdfsdf     |            |
      |              | !!!!!    | Palacio  | @%#%#      | 29/07/2022 |
      |              |          | 234234   |            | sdfsdf     |
      |              | Emiliano | ##%##    | 26/07/2022 | #$##       |
      | Crowdar-Test | !!!!!    | 234234   | 26/07/2022 |            |
      | Crowdar-Test |          | ##%##    | sdfsdf     | 29/07/2022 |
      | Crowdar-Test | Emiliano |          | @%#%#      | sdfsdf     |
      | Crowdar-Test | 234234   | Palacio  |            | #$##       |


      #MM-829
  @Ignore
  Scenario Outline: Usar el Filtro de Credencial revocadas
    Given el admin esta logueado en la web de coopsol
    When  el admin selecciona "Credenciales Revocadas"
    And  el admin completa el filtro "Tipo" con <Tipo>
    And  el admin completa el filtro "Nombre" con <Nombre>
    And  el admin completa el filtro "Apellido" con <Apellido>
    And  el admin completa el filtro "Desde" con <Desde>
    And  el admin completa el filtro "Hasta" con <Hasta>  and  el admin da click en el boton "Buscar"
    Then se muestran los resultados de acuerdo al criterio de busqueda.

    Examples:

      | Tipo                              | Nombre   | Apellido | Desde      | Hasta      |
      | Financiera                        | Lourdes  | Allub    | 24/08/2022 | 25/08/2022 |
      |                                   |          |          | 06/07/2022 | 07/07/2022 |
      |                                   | Claudia  |          |            |            |
      | Identitaria                       |          |          |            |            |