# <div align="center"> Progetto_PO </div>

<h1 align="center"> 🇲🇽 TicketMaster Mexico 🇲🇽</h1>
 
<p align="center">Il progetto ha lo scopo di offire un servizio sull'analisi degli eventi che si terranno negli stati del Messico.
L'utente ha la possibilità di ottenere delle statistiche e dei filtri a seconda dei dati immessi.</p>

<h2>INDICE 🗂️</h2>

* [Introduzione](https://github.com/MazzariniTommaso/Progetto_PO#introduzione)
* [Installazione](https://github.com/MazzariniTommaso/Progetto_PO#installazione-e-configurazione)
* [Rotte disponibili](https://github.com/MazzariniTommaso/Progetto_PO#rotte-disponibili)
   * [Statistiche](https://github.com/MazzariniTommaso/Progetto_PO#statistiche)
   * [Filtri](https://github.com/MazzariniTommaso/Progetto_PO#filtri)
* [Test](https://github.com/MazzariniTommaso/Progetto_PO#test)
* [Autori](https://github.com/MazzariniTommaso/Progetto_PO#autori)

# Introduzione 📍
Il programma tramite l'API TicketMaster il programma riceve i dati riguardanti gli eventi che si svolgeranno negli stati del Messico.
Per maggiori informazioni, la descrizione dell'API si trova nel seguente [link](https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2).

# Installazione e configurazione ✅
L'applicazione è installabile usando Git tramite l'IDE eclipse oppure digitando nella Git Bash:
```
git clone https://github.com/MazzariniTommaso/Progetto_PO.git
```
Infine occorre avviare l'applicazione eseguendo [ProjectOopApplication.java](https://github.com/MazzariniTommaso/Progetto_PO/blob/main/src/main/java/it/univpm/ProjectOOP/ProjectOopApplication.java) come Spring Boot Application.
Una volta avviata si potrà usufruire del servizio richiedendo le rotte disponibili tramite Postman (o simili).

# Rotte disponibili 🌐
Dal programma vengono rese disponibili le seguenti rotte che l'utente può richiedere tramite Postman sulla porta 8080 del localhost:
 
|Metodo|Rotta|Funzione|
|-|-|-|
| **GET**|`/stats`| Mostra le statistiche per ogni stato|
|**GET**| `/filtres`| Genera filtri|

---

## Statistiche 📈
Per poter ottenere le statistiche viene resa disponibile la rotta **"/stats"**, che deve essere utilizzata con il metodo **GET**.
Non vengono richiesti parametri, genera le statistiche per ogni stato presente nel Json fornitoci dall'API.

La rotta restituirà un oggetto che descrive le statistiche avente la seguente struttura:
* **"state"** nome dello stato.
* **"total"** numero totale di eventi dello stato.
* **"genre"** array con all'interno le specifiche del genere.
    * **name"** nome del genere.
    * **eventNumber** numero degli eventi di quel genere.
* **"year"** array contenente i mesi in cui sia presente almeno un evento.
	* **number"** numero dell'anno.
	* **month"** array di mesi con il numero minimo/medio/massimo di eventi.
		* **name"** nome del mese.
		* **eventMin"** numero minimo di eventi in un giorno del mese sopra specificato.
		* **eventMax"** numero massimo di eventi in un giorno del mese sopra specificato.
		* **eventMed"** numero medio di eventi del mese.
		* **eventTot"** numero totale di eventi del mese.
		 
Un esempio del risultato ottenuto:

```
     {
        "state": "Distrito Federal",
        "total": 177,
        "genre": [
            {
                "name": "Theatre",
                "eventNumber": 113
            },
            {
                "name": "Rock",
                "eventNumber": 3
            },
            {
                "name": "Soccer",
                "eventNumber": 3
            },
            {
                "name": "Community/Civic",
                "eventNumber": 19
            },
            {
                "name": "Dance",
                "eventNumber": 6
            },
            {
                "name": "Latin",
                "eventNumber": 3
            },
            {
                "name": "Comedy",
                "eventNumber": 5
            },
            {
                "name": "Miscellaneous Theatre",
                "eventNumber": 9
            },
            {
                "name": "Espectaculo",
                "eventNumber": 1
            },
            {
                "name": "Boxing",
                "eventNumber": 8
            },
            {
                "name": "Classical",
                "eventNumber": 3
            },
            {
                "name": "Children's Theatre",
                "eventNumber": 2
            },
            {
                "name": "Ballads/Romantic",
                "eventNumber": 1
            },
            {
                "name": "Other",
                "eventNumber": 1
            }
        ],
        "year": [
            {
                "number": "2021",
                "month": [
                    {
                        "name": "June",
                        "eventMin": 0,
                        "eventMax": 1,
                        "eventMed": 0.032258064,
                        "eventTot": 1
                    },
                    {
                        "name": "July",
                        "eventMin": 0,
                        "eventMax": 1,
                        "eventMed": 0.032258064,
                        "eventTot": 1
                    },
                    {
                        "name": "November",
                        "eventMin": 0,
                        "eventMax": 2,
                        "eventMed": 0.06451613,
                        "eventTot": 2
                    }
                ]
            },
            {
                "number": "2022",
                "month": [
                    {
                        "name": "January",
                        "eventMin": 0,
                        "eventMax": 50,
                        "eventMed": 5.580645,
                        "eventTot": 173
                    }
                ]
            }
        ]
    },
    {
        "state": "Quintana Roo",
        "total": 16,
        "genre": [
            {
                "name": "Circus & Specialty Acts",
                "eventNumber": 16
            }
        ],
        "year": [
            {
                "number": "2022",
                "month": [
                    {
                        "name": "January",
                        "eventMin": 0,
                        "eventMax": 2,
                        "eventMed": 0.516129,
                        "eventTot": 16
                    }
                ]
            }
        ]
    },
    {
        "state": "Estado de México",
        "total": 5,
        "genre": [
            {
                "name": "Theatre",
                "eventNumber": 5
            }
        ],
        "year": [
            {
                "number": "2022",
                "month": [
                    {
                        "name": "January",
                        "eventMin": 0,
                        "eventMax": 2,
                        "eventMed": 0.16129032,
                        "eventTot": 5
                    }
                ]
            }
        ]
    },
    {
        "state": "Jalisco",
        "total": 1,
        "genre": [
            {
                "name": "Boxing",
                "eventNumber": 1
            }
        ],
        "year": [
            {
                "number": "2022",
                "month": [
                    {
                        "name": "January",
                        "eventMin": 0,
                        "eventMax": 1,
                        "eventMed": 0.032258064,
                        "eventTot": 1
                    }
                ]
            }
        ]
    }
```



Durante l'utilizzo della rotta possono essere lanciate, in caso di errori, le seguenti eccezioni:
* **ParseException** : se si verifica un errore durante il parsing dei dati forniti dall' API di Ticketmaster.
* **MalformedURLException** : se l'URL dell' API di Ticketmaster non corretto.
* **IOException** : se ci sono errori durante la lettura dei dati forniti da Ticketmaster.

---

## Filtri 📊
Per poter ottenere dei filtri riguardo i dati degli eventi dei stati viene resa disponibile la rotta **"/filtres"**, che deve essere utilizzata con il metodo **GET**.
I filtri generati in base a valori personalizzati di stati, generi e periodo permettono di ottenere valori di minimo, massimo e media eventi. 

<h3>Parametri</h3>

| Chiave              | Valore                                                                        |
|---------------------|-------------------------------------------------------------------------------|
| **"states"**            | lista degli stati                                                             |
| **"genres"**            | lista dei generi                                                              |
| **"startDate"**        | data di inizio                                                                |
| **"endDate"**          | data di fine                                                                  |



Forniamo un esempio di quella che potrebbe essere una richiesta:

![alt_text](https://github.com/MazzariniTommaso/Progetto_PO/blob/main/img/Esempio_richiesta_filtri.PNG)

Dove:
* **"states"** : la lista degli stati che può essere anche vuota o contenere un solo stato, nel caso in cui sia vuota l'applicazione restituirà un elenco con tutti gli stati presenti nell'API di ticketmaster. Per inserire più stati occorre scrivere in CSV ("comma separated values":ovvero separando i vari nomi degli stati da virgole e senza spazi).
* **"genres"** : la lista dei generi, anche essa può essere vuota o contenere un solo genere e nel caso sia vuota verrà fornito tutta la lista dei generi degli eventi. Per inserire più generi occore scrivere in CSV ("comma separated values":ovvero separando i vari nomi dei generi da virgole e senza spazi).
* **"startDate"** : la data di inizio, se non specificata verrà considerata come data iniziale per l'intervallo temporale la data del primo evento presente nel Json fornitoci dall'API.
* **"endDate"** : la data di fine, se non specificata verrà considerata come data finale per l'intervallo temporale la data dell'ultimo evento presente nel Json fornitoci dall'API. Quindi l'utente ha la possibilità di immettere i parametri che desidera, non obbligatoriamente tutti e 4.

La rotta restituirà un oggetto che descrive i filtri desiderati a seconda dei parametri immessi, che ha la seguente struttura:
* **state** : contiene i filtri riguardanti gli stati.
    * **stateList** : array con i nomi dei stati immessi dall'utente.
    * **numMinPerState** : numero minimo di eventi fra gli stati filtrati.
    * **numMaxPerState** : numero massimo di eventi fra gli stati filtrati.
    * **numMedPerState** : numero medio di eventi fra gli stati filtrati.
* **genre** : contiene i filtri riguardanti i generi.
    * **genreList** : array dei nomi dei generi passati dall'utente.
    * **numMinPerGenre** : numero minimo di eventi fra i generi filtrati.
    * **numMaxPerGenre** : numero massimo di eventi fra i generi filtrati.
    * **numMedPerGenre** : numero medio di eventi fra i generi filtrati.
* **period** : contiene la data di inizio e fine del periodo in cui si vogliono ricavare le informazioni.
    * **startDate** : data di inizio.
        * **day** : giorno
        * **month** : mese
        * **year** : anno
    * **endDate** : data di fine.
        * **day** : giorno
        * **month** : mese
        * **year** : anno
    * **numMinPerDate** : numero minimo di eventi presenti in un singolo giorno.
    * **numMaxPerDate** : numero massimo di eventi presenti in un singolo giorno.
    * **numMedPerDate** : numero medio di eventi nell'intervallo di tempo.
```
{
    "state": {
        "stateList": [
            "Distrito Federal",
            "Quintana Roo"
        ],
        "numMinPerState": 0,
        "numMaxPerState": 3,
        "numMedPerState": 1.5
    },
    "genre": {
        "genreList": [
            "Classical"
        ],
        "numMinPerGenre": 3,
        "numMaxPerGenre": 3,
        "numMedPerGenre": 3.0
    },
    "period": {
        "startDate": {
            "day": "01",
            "month": "January",
            "year": "2022"
        },
        "endDate": {
            "day": "31",
            "month": "March",
            "year": "2022"
        },
        "numMinPerDate": 0,
        "numMaxPerDate": 2,
        "numMedPerDate": 0.27272728
    }
}
```


Durante l'utilizzo della rotta possono essere lanciate, in caso di errori, le seguenti eccezioni:
* **ParseException** : se si verifica un errore durante il parsing dei dati forniti dall' API di Ticketmaster.
* **MalformedURLException** : se l'URL dell' API di Ticketmaster non corretto.
* **IOException** : se ci sono errori durante la lettura dei dati forniti da Ticketmaste.
* **UncorrectDate** : se l'utente non ha inserito correttamente una data.
* **UnlogicalDate** : se l'utente ha inserito la data finale precedente alla data iniziale per la definizione del periodo.
* **EmptyList** : se non sono presenti eventi che corrispondono ai filtri inseriti dall'utente.
* **UncorrectState** : se l'utente non ha inserito correttamente il nome dello stato oppure esso non è presente.
* **UncorrectGenre** : se l'utente non ha inserito correttamente il nome del genere oppure esso non è presente.

---

# Test ⚠️

Abbiamo implementato i seguenti test per verificare il corretto funzionamento di alcuni metodi e alcune eccezioni:

- **ParsignTest** : per testare il metodo che gestisce le chiamate API e restituisce una lista di Eventi.
- **ToolTest** : per testare alcuni metodi della classe Tool.
- **StatsServiceTest** : per testare la classe StatsService che restituisce le statistiche dopo essere state richieste tramite root.
- **ExceptionTest** : per testare alcune eccezzioni fra quelle create per una migliore gestione degli errori.
- **FiltresServiceTest** : per testare la classe FiltresService che si occupa di restituire i filtri a seconda dei valori immessi dall'utente.
---

# Autori ✒️
| Sviluppatore|Email|
|--|--|
| Mazzarini Tommaso |s1100538@studenti.univpm.it  |
| Merelli Leonardo |s1100073@studenti.univpm.it |
