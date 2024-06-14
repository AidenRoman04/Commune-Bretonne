
CREATE USER nomEtud@localhost IDENTIFIED BY 'motdepasse' ;
CREATE DATABASE bdSAE ;
GRANT ALL ON bdSAE.* TO nomEtud@localhost ;