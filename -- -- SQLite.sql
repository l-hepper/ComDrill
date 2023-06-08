-- -- SQLite


-- Code for creating Cards table 
-- CREATE TABLE Cards (
--     ID INTEGER PRIMARY KEY AUTOINCREMENT,
--     Front TEXT,
--     Back TEXT,
--     DeckName TEXT,
--     FOREIGN KEY(DeckName) REFERENCES DECKS(DeckName)
-- );


-- Code for creating Decks table
-- CREATE TABLE Decks (
--     DeckName TEXT PRIMARY KEY,
--     NumberOfCards INT NOT NULL,
--     Active INT NOT NULL
-- );

-- Used to create another deck
-- INSERT INTO DECKS VALUES (deckName, 0, 1);

-- use this to delete a table, it will also delete the auto increment data
-- DELETE FROM Decks WHERE DeckName='deck_name';