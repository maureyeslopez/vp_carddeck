# vp_carddeck
## Deck of cards library 
* Services for getting cards, putting cards, shuffling and sorting the deck.
* Implementation of French and Spanish Deck

## REST Interfaces for testing French Deck and Spanish Deck

### API
French Deck BASE URL: **/vp_carddeck/frenchDeck**<br/>
Spanish Deck BASE URL: **/vp_carddeck/spanishDeck**

| API        | Verb           | Params  | Description        |
| ---------- | -------------- | ------- |------------------- |
| start      | POST           |         | Starts a new deck  |
| destroy    | DELETE         |         | Destroys current deck |
| shuffle    | PUT            |         | Shuffles currect deck |
| card/any   | GET            |         | Gets a card from any position of the current deck |
| card/top   | GET            |         | Gets the card on top of the current deck |
| card/top   | PUT            |Card *(see below)*         | Puts a card on top of the current deck |
| card/bottom| GET            |         | Gets the card at the bottom of the current deck |
| card/bottom| PUT            |Card *(see below)*         |Puts a card at the bottom of the current deck |
| sort/rank  | PUT            |         |Sorts the current deck by rank and then by suit|
| sort/suit  | PUT            |         |Sorts the current deck by suit and then by rank |

#### Params
* Card
  * French Card Format
```json
{
  "suit":{
       "name":"SUIT_NAME" 
  },
  "rank":{
       "value":"A_VALUE" 
  }
}
```
French Suit Names: Hearts, Clubs, Diamonds, Spades.<br/>
French Ranks: 2-10, J, Q, K, A **_Note that you should send both numbers and letters as String values in French Deck_**
  * Spanish Card
```json
{
  "suit":{
       "name":"SUIT_NAME" 
  },
  "rank":{
       "number":A_NUMBER
  }
}
```
Spanish Suit Names: Basto, Oro, Copa, Espada.<br/>
Spanish Ranks: 1-12

#### Examples
```bash
> POST /vp_carddeck/frenchDeck/start
  Deck started
> PUT /vp_carddeck/frenchDeck/shuffle
  Deck shuffled
> GET /vp_carddeck/frenchDeck/card/any
  {"suit":{"name":"Hearts"},"rank":{"number":6},"color":"RED"}
> PUT /vp_carddeck/frenchDeck/card/top Params {"suit":{"name":"Hearts"},"rank":{"number":"6"}}
  Card added
> PUT /vp_carddeck/frenchDeck/card/top Params {"suit":{"name":"Hearts"},"rank":{"number":"6"}}
  6 Hearts is already on the deck
> PUT /vp_carddeck/frenchDeck/sort/rank
  Deck sorted by rank
> GET /vp_carddeck/frenchDeck/card/top
  {"suit":{"name":"Clubs"},"rank":{"number":2},"color":"BLACK"}
> GET /vp_carddeck/frenchDeck/card/bottom
  {"suit":{"name":"Spades"},"rank":{"letter":"A"},"color":"BLACK"}
> DELETE /vp_carddeck/frenchDeck/destroy
  Deck destroyed
> GET /vp_carddeck/frenchDeck/card/bottom
  There's no deck
```

### Running
You can generate a WAR from code or check inside dist folder for an already generated WAR. It was tested on WildFly 10.
