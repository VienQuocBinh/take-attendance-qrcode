-- CREATE DATABASE prj301-take-attendence

CREATE TABLE student (
	id INT PRIMARY KEY,
    email NVARCHAR(40),
    username NVARCHAR(40),
    classNumber NVARCHAR(4),
    subjectCode NVARCHAR(6),
    slot INT,
    dates DATE
)

DROP TABLE student