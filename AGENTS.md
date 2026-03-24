# AGENTS.md - Algoritmo de Berkeley

Este arquivo contém informações essenciais para agentes de IA que trabalham neste repositório.

## Visão Geral do Projeto

Implementação simples e didática do **Algoritmo de Berkeley** para sincronização de relógios em sistemas distribuídos. O projeto é voltado para apresentação acadêmica, simulando múltiplos nós localmente (sem comunicação de rede real/RMI).

### Objetivo
- Demonstrar o funcionamento do Algoritmo de Berkeley
- Implementação teórica para trabalho de faculdade
- Execução local em um único computador (mesma JVM)
- Saída visual simples mostrando cálculos detalhados

## Estrutura do Projeto

```
src/
├── br/
│   └── berkeley/
│       ├── model/                  (Modelos de dados)
│       │   ├── Clock.java         (Representa um relógio)
│       │   └── Node.java          (Representa um nó)
│       │
│       └── service/                (Lógica de negócio)
│           └── MasterServer.java  (Implementa algoritmo)
│
└── Main.java                       (Ponto de entrada - sem pacote)
```

## Build, Compilação e Execução

### Compilar o projeto
```bash
cd src
javac br/berkeley/model/*.java br/berkeley/service/*.java Main.java
```

### Executar o programa
```bash
cd src
java Main
```

### Limpar arquivos compilados
```bash
cd src
find . -name "*.class" -type f -delete
```

### Compilar e executar (comando único)
```bash
cd src && javac br/berkeley/model/*.java br/berkeley/service/*.java Main.java && java Main
```

## Saída Esperada

```
Antes da sincronizacao:
Mestre: 10:10:00
A: 10:30:00
B: 09:45:00
C: 09:30:00
D: 10:25:00

Calculando media...
Mestre: 36600s
A: 37800s
B: 35100s
C: 34200s
D: 37500s
Soma total: 181200s
Numero de nos: 5
Media: 181200 / 5 = 36240s

Media calculada: 10:04:00

Ajustes necessarios:
Mestre: 36240 - 36600 = -360s
A: 36240 - 37800 = -1560s
B: 36240 - 35100 = +1140s
C: 36240 - 34200 = +2040s
D: 36240 - 37500 = -1260s

Depois da sincronizacao:
Mestre: 10:04:00
A: 10:04:00
B: 10:04:00
C: 10:04:00
D: 10:04:00
```

## Convenções de Código

### Nomenclatura

**Português (onde aluno brasileiro naturalmente usaria):**
- Variáveis: `relogio`, `cliente`, `mestre`, `ajuste`, `media`, `soma`, `tempoMestre`
- Métodos simples: `calcular`, `aplicar`, `ajustar`, `sincronizar`
- Parâmetros: `horas`, `minutos`, `segundos`, `offsetSegundos`

**Inglês (convenções Java/padrão):**
- Nomes de classes: `Clock`, `Node`, `MasterServer`, `Main`
- Getters: `getId()`, `getRelogio()`, `getTotalSegundos()`
- Estruturas Java padrão: `List`, `ArrayList`, `String`

### Formatação
- Indentação: 4 espaços (sem tabs)
- Chaves: estilo Java (abertura na mesma linha)
- **SEM COMENTÁRIOS** no código - código deve ser auto-explicativo
- Nomes descritivos em português para variáveis e métodos internos

### Imports
- Um import por linha
- Ordenação: pacotes do projeto primeiro, depois java.*
- Sem imports desnecessários
- Exemplo:
```java
import br.berkeley.model.Clock;
import br.berkeley.model.Node;
import java.util.ArrayList;
import java.util.List;
```

### Tratamento de Erros
- Não há tratamento de exceções neste projeto (código simples e controlado)
- Assume-se entradas válidas

### Prints e Saída
- Usar `System.out.println()` para saída
- Concatenação simples: `"texto " + variavel + " mais " + outra`
- **NÃO usar** formatação complexa ou decorações (ASCII art, bordas, etc)
- Saída deve ser limpa e funcional, não "bonita"

## Regras Específicas do Projeto

### Clock.java
- Armazena tempo como `int totalSegundos` internamente
- Conversão HH:MM:SS ↔ segundos feita no construtor e toString()
- Método `ajustar(int offsetSegundos)` permite ajustes positivos/negativos
- Formato de saída: "HH:MM:SS" (sempre 2 dígitos, ex: "09:04:00")

### Node.java
- Representa um nó (mestre ou cliente) com ID e relógio
- Delega ajustes para o objeto Clock interno
- Simples: apenas wrapper para Clock com identificação

### MasterServer.java
- **NÃO faz prints** - apenas lógica do algoritmo
- Método `sincronizar()` calcula média e aplica ajustes
- Usa loops simples, sem estruturas complexas (HashMap desnecessário)
- Lógica pura de sincronização

### Main.java
- **SEM package declaration** (fica na raiz de src/)
- Responsável por TODOS os prints (estado inicial, cálculos, estado final)
- Cria 5 nós: 1 mestre + 4 clientes (A, B, C, D)
- Mostra cálculos manualmente com concatenação de variáveis
- Chama `servidor.sincronizar()` para aplicar ajustes

## TODO List do Projeto

### ✅ Concluído
- [x] Estrutura de diretórios criada
- [x] Planejamento completo finalizado
- [x] AGENTS.md criado
- [x] Implementar `Clock.java` no pacote `br.berkeley.model`
   - Atributos: `int totalSegundos`
   - Construtor: `Clock(int horas, int minutos, int segundos)`
   - Métodos: `getTotalSegundos()`, `ajustar(int offsetSegundos)`, `toString()`

### 🚧 Em Progresso
- [ ] Implementar `Node.java` no pacote `br.berkeley.model`

### 📋 Pendente
1. Implementar `Node.java` no pacote `br.berkeley.model`
   - Atributos: `String id`, `Clock relogio`
   - Construtor: `Node(String id, Clock relogio)`
   - Métodos: `getId()`, `getRelogio()`, `ajustarRelogio(int offset)`

2. Implementar `MasterServer.java` no pacote `br.berkeley.service`
   - Atributos: `Node mestre`, `List<Node> clientes`
   - Construtor: `MasterServer(Node mestre, List<Node> clientes)`
   - Método: `sincronizar()` - calcula média e aplica ajustes (SEM prints)

3. Implementar `Main.java` (raiz de src/, sem pacote)
   - Criar 5 nós com horários diferentes
   - Imprimir estado inicial
   - Imprimir cálculos detalhados (conversão, soma, média, ajustes)
   - Chamar `servidor.sincronizar()`
   - Imprimir estado final

4. Testar compilação e execução
   - Verificar saída está exatamente como esperado
   - Validar cálculos matemáticos

## Notas Importantes

- **Simplicidade é prioridade**: código deve ser direto e fácil de entender
- **Sem dependências externas**: apenas JDK padrão (Java 8+)
- **Sem Java RMI**: simulação local apenas, tudo na mesma JVM
- **Foco no algoritmo**: não em infraestrutura de rede/distribuição real
- **Uma classe por vez**: implementar e validar individualmente antes de prosseguir

## Validação dos Cálculos

**Tempos iniciais (em segundos):**
- Mestre: 10:10:00 = 36600s
- A: 10:30:00 = 37800s
- B: 09:45:00 = 35100s
- C: 09:30:00 = 34200s
- D: 10:25:00 = 37500s

**Cálculo esperado:**
- Soma: 181200s
- Média: 181200 ÷ 5 = 36240s = 10:04:00
- Todos os nós devem convergir para 10:04:00
