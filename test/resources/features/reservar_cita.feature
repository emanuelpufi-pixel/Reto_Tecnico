Feature: Reserva de citas en JQuery Datepicker
  Como usuario del Datepicker,
  Quiero seleccionar una fecha en el calendario
  Para reservar una cita.

  Scenario: Seleccionar el dia 15 del mes actual
  Given que Laura quiere reservar una cita
  When ella selecciona el dia "15" del mes actual
  Then el campo de fecha debe mostrar el dia "15" de este mes
