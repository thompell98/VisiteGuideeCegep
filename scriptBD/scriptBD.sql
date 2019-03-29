DROP DATABASE IF EXISTS `bd_projet`;
CREATE DATABASE `bd_projet`;
USE `bd_projet`;

CREATE TABLE tblLocaux(
        idLocal Int  Auto_increment  NOT NULL ,
        identification Nvarchar (50) NOT NULL ,
        nom Nvarchar (50) NOT NULL,
        description Nvarchar (500) NOT NULL
	,CONSTRAINT Local_PK PRIMARY KEY (idLocal)
)ENGINE=InnoDB;

CREATE TABLE tblPhotos(
        idPhoto Int  Auto_increment  NOT NULL ,
        path Nvarchar (100) NOT NULL ,
        idLocal Int NOT NULL
	,CONSTRAINT Photo_PK PRIMARY KEY (idPhoto)
	,CONSTRAINT Photo_Local_FK FOREIGN KEY (idLocal) REFERENCES tblLocaux(idLocal)
)ENGINE=InnoDB;

CREATE TABLE tblPositions(
        idPosition Int  Auto_increment  NOT NULL ,
        x Float NOT NULL ,
        y Float NOT NULL,
        idLocal Int NOT NULL
	,CONSTRAINT Position_PK PRIMARY KEY (idPosition)
	,CONSTRAINT Position_Local_FK FOREIGN KEY (idLocal) REFERENCES tblLocaux(idLocal)
)ENGINE=InnoDB;