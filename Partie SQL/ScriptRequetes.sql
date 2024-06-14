-- Question 1 : Quels sont les noms des aéroports du Finistère ?

-- Requête :
SELECT nom
FROM Aeroport
JOIN Departement ON leDepartement = idDep
WHERE UPPER(nomDep) = 'FINISTERE';

-- Resultat : 3 tuples
/*
BREST-BRETAGNE
MORLAIX-PLOUJEAN
QUIMPER-PLUGUFFAN
*/

-- Question 2 : Quels départements ont plus investi dans la culture que le Morbihan en 2019 ?
-- Requête : 
SELECT d2.nomDep
FROM Departement d1, Departement d2
WHERE d1.investissementCulturel2019 < d2.investissementCulturel2019
AND UPPER(d1.nomDep) = 'MORBIHAN'
AND UPPER(d2.nomDep) != 'MORBIHAN';

-- Resultat : 2 tuples
/*
FINISTERE
ILLE-ET-VILAINE
*/

-- Question 3 : Quelles communes d'Ille-et-Vilaine ne possèdent pas de gare ?
-- Requête :
SELECT nomCommune
FROM Commune
LEFT JOIN Gare ON laCommune = idCommune
WHERE codeGare IS NULL
AND leDepartement = 35;

-- Resultat : 289 tuples
-- 5 premiers tuples :
/*
ACIGNE
AMANLIS
ANDOUILLE-NEUVILLE
VAL-COUESNON
ARBRISSEL
*/

-- Question 4 : Quels sont les communes sans département ?
-- Requête :
SELECT nomCommune
FROM Commune
LEFT JOIN Departement ON leDepartement = idDep
WHERE nomDep IS NULL;

-- Resultat : 0 tuples

-- Question 5 : Quelles sont les communes qui n'ont aucun voisin ?
-- Requête :
SELECT nomCommune
FROM Commune
WHERE idCommune NOT IN (SELECT commune FROM Voisinage);

-- Resultat : 12 tuples
-- 5 premiers tuples :
/*
ILE-DE-BREHAT
BEAUSSAIS-SUR-MER
AUDIERNE
ILE-DE-BATZ
ILE-DE-SEIN
*/

-- Question 6 : Quelles sont les années où des données ont été receuillies ?
-- Requête :
SELECT annee
FROM Annee
WHERE annee IN (SELECT lAnnee FROM DonneesAnnuelles);

-- Resultat : 4 tuples
/*
2018
2019
2020
2021
*/

-- Question 7 : Quelles sont les gares dont la commune possède au moins une commune voisine ?
-- Requête :
SELECT nomGare
FROM Gare AS gare
WHERE EXISTS (SELECT * FROM Voisinage WHERE commune = gare.laCommune);

-- Resultat : 137 tuples
/*
KER-LANN
TRAOU-NEZ
CESSON-SEVIGNE
LA POTERIE
RENNES
*/

-- Question 8 : Quels sont les departements qui ne possèdent pas d'aéroport ?
-- Requête :
SELECT nomDep
FROM Departement
WHERE NOT EXISTS (
    SELECT * FROM Aeroport WHERE leDepartement = idDep
);
-- Resultat : 0 tuple
/*

*/

-- Question 9 : Quel est le nombre moyen d'appartements vendus ?
-- Requête : 
SELECT AVG(nbAppart)
FROM DonneesAnnuelles;

-- Resultat : 13.8291

-- Question 10 : Quel est le prix moyen le plus élevé ?
-- Requête :
SELECT MAX(prixMoyen)
FROM DonneesAnnuelles;

-- Resultat : 603838

-- Question 11 : Quel est le prix moyen des propriétés par commune ?
-- Requête :
SELECT laCommune, AVG(prixMoyen)
FROM DonneesAnnuelles
GROUP BY laCommune;

-- Resultat : 1205 tuples
-- 5 premiers tuples
/*
22001	101101.05078125
22002	185775.5
22003	185911
22004	115727.75
22005	88147.724609375
*/

-- Question 12 : Quel est le nombre d'appartements vendus par année ?
-- Requête :
SELECT lAnnee, SUM(nbAppart)
FROM DonneesAnnuelles
GROUP BY lAnnee;
-- Resultat : 4 tuples
/*
2018	15083
2019	17344
2020	16333
2021	17661
*/

-- Question 13 : En quelles années le prix moyen des ventes était-il supérieur à 150000€ ?
-- Requête :
SELECT lAnnee, AVG(prixMoyen) AS PrixMoy
FROM DonneesAnnuelles
GROUP BY lAnnee
HAVING PrixMoy > 150000;

-- Resultat : 2 tuples
/*
2020	158303.30966796874
2021	177211.27047693948
*/

-- Question 14 : Quelles sont les communes dont la somme du budget total est supérieur à 100000€ ?
-- Requête :
SELECT laCommune, SUM(budgetTotal) AS budget
FROM DonneesAnnuelles
GROUP BY laCommune
HAVING budget > 100000;

-- Resultat : 2 tuples
/*
29019	131384
35238	344668
*/

-- Question 15 : Afficher le nom des villes possedant une gare pour toute les villes?
-- Requête :


-- Resultat : x tuples
/*
*/

-- Question 16 :
-- Requête :
-- Resultat : x tuples
/*
*/

-- Question 17 :
-- Requête :
-- Resultat : x tuples
/*
*/

-- Question 18 :
-- Requête :
-- Resultat : x tuples
/*
*/

-- Question 19 : Créer une vue qui calcule le nombre de biens immobiliers vendus pas commune en 2019
-- Requête :
CREATE OR REPLACE VIEW biensImmoCommune
AS
SELECT laCommune, nbAppart + nbMaison AS nbBiensImmo
FROM DonneesAnnuelles
WHERE lAnnee = 2019;

SELECT *
FROM biensImmoCommune
LIMIT 10000;
-- Resultat : 1200 tuples
-- 5 premiers tuples :
/*
22001	8
22002	11
22003	11
22004	71
22005	15
*/

-- Question 20 :
-- Requête :
-- Resultat : x tuples
/*
*/
