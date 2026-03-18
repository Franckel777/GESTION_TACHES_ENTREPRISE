 CREATE TABLE taches (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    description TEXT,
    responsable VARCHAR(100) NOT NULL,
    statut  ENUM('A_FAIRE', 'EN_COURS', 'TERMINEE') NOT NULL,
); 