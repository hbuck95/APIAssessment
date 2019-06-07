--Prepopulate tables
INSERT INTO Classroom(classroomID, trainer) VALUES (1, 'Matt Hunt');
INSERT INTO Classroom(classroomID, trainer) VALUES (2, 'Chester Gardener');

INSERT INTO Trainee(traineeID, traineeName, classroom) VALUES (1, 'Joe Bloggs', 1);
INSERT INTO Trainee(traineeID, traineeName, classroom) VALUES (2, 'Jane Bloggs', 1);
INSERT INTO Trainee(traineeID, traineeName, classroom) VALUES (3, 'David Bloggs', 2);
INSERT INTO Trainee(traineeID, traineeName, classroom) VALUES (4, 'Ceri Bloggs', 2);