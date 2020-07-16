DROP table IF EXISTS game;
DROP TABLE IF EXISTS player;
DROP table IF EXISTS toss;

CREATE TABLE `player` (
`id` int(11) NOT NULL AUTO_INCREMENT,   
`name` varchar(250) DEFAULT  "anonime" , 
`totalpoints` int(11) DEFAULT 0,   
`winrate` DECIMAL(5) DEFAULT 0.00,  
PRIMARY KEY (`id`)  
);

CREATE TABLE `toss` (
`id` int(11) NOT NULL AUTO_INCREMENT,   
`dice1` int(11) DEFAULT NULL,   
`dice2` int(11) DEFAULT NULL,   
`registration` date DEFAULT NULL,   
PRIMARY KEY (`id`)    
);

CREATE TABLE `game` (
`id` int(11) NOT NULL AUTO_INCREMENT,   
`timestamp` date DEFAULT NULL,  
`player1_id` int(11) NOT NULL,  
`player2_id` int(11) NOT NULL,  
`toss1_id` int(11) NOT NULL,  
`toss2_id` int(11) NOT NULL,  
`winner_id` int(11) DEFAULT NULL,  
CONSTRAINT `player1_fk`  FOREIGN KEY (`player1_id`) REFERENCES `player` (`id`),  
 CONSTRAINT `player2_fk` FOREIGN KEY (`player2_id`) REFERENCES `player` (`id`),  
 CONSTRAINT `tosse1_fk` FOREIGN KEY (`toss1_id`) REFERENCES `toss` (`id`),  
 CONSTRAINT `tosse2_fk` FOREIGN KEY (`toss2_id`) REFERENCES `toss` (`id`),  
 CONSTRAINT `winner_fk` FOREIGN KEY (`winner_id`) REFERENCES `player` (`id`),  
PRIMARY KEY (`id`)  
);

insert into player(name,totalpoints)values('Eathan Frame',10);
insert into player(name,totalpoints, winrate)values('Marianna Horne',10,1);
insert into player(name,totalpoints)values('Zackary Farrington',10);
insert into player(name,totalpoints,winrate)values('Angharad Mccormick',10,1);

insert into toss(dice1,dice2)values(1,2);
insert into toss(dice1,dice2)values(5,2);
insert into toss(dice1,dice2)values(1,4);
insert into toss(dice1,dice2)values(2,5);
insert into toss(dice1,dice2)values(3,4);
insert into toss(dice1,dice2)values(5,6);

insert into game(player1_id,toss1_id,player2_id,toss2_id,winner_id)values(1,1,2,2,2);
insert into game(player1_id,toss1_id,player2_id,toss2_id,winner_id)values(3,3,4,4,4);


