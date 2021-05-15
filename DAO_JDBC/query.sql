/*Select vendedor*/
SELECT vendedor.*,departamento.Nome as DepNome
FROM vendedor INNER JOIN departamento
ON vendedor.Id_dpt = departamento.ID
WHERE vendedor.ID = ?

/*select departamento*/
SELECT vendedor.*,departamento.Nome as DepNome
FROM vendedor INNER JOIN departamento
ON vendedor.Id_dpt = departamento.ID
WHERE Id_dpt = ?
ORDER BY Nome

/*Find ALL */
SELECT vendedor.*,departamento.Nome as DepNome
FROM vendedor INNER JOIN departamento
ON vendedor.Id_dpt = departamento.ID
ORDER BY Nome

/* Insert */
INSERT INTO vendedor
(Nome, Email, Data_Nascimento, Salario_Base, Id_dpt)
VALUES
(?, ?, ?, ?, ?)

/* UPDATE */
UPDATE vendedor
SET Nome = ?, Email = ?, Data_Nascimento = ?, Salario_Base = ?, Id_dpt = ?
WHERE Id = ?