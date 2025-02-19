INSERT INTO CUENTA (NUMERO_CUENTA, TIPO_CUENTA, SALDO_INICIAL, ESTADO, CLIENTE)
VALUES ('478758', 'AHORRO', 2000, TRUE, 'Jose Lema'),
       ('225487', 'CORRIENTE', 100, TRUE, 'Marianela Montalvo'),
       ('495878', 'AHORRO', 0, TRUE, 'Juan Osorio'),
       ('496825', 'AHORRO', 540, TRUE, 'Marianela Montalvo'),
       ('585545', 'CORRIENTE', 1000, TRUE, 'Jose Lema');

INSERT INTO Movimiento (FECHA, SALDO, TIPO_MOVIMIENTO, VALOR, CUENTA_ID)
VALUES ('2025-02-19', 2000 - 575, 'RETIRO', -575, (SELECT id FROM Cuenta WHERE numero_cuenta = '478758')),
       ('2025-02-19', 100 + 600, 'DEPOSITO', 600, (SELECT id FROM Cuenta WHERE numero_cuenta = '225487')),
       ('2025-02-19', 0 + 150, 'DEPOSITO', 150, (SELECT id FROM Cuenta WHERE numero_cuenta = '495878')),
       ('2025-02-19', 540 - 540, 'RETIRO', -540, (SELECT id FROM Cuenta WHERE numero_cuenta = '496825'));
