# Mega Projeto Java — V3 GitHub Edition

Projeto educacional + arcade para **Java 17+**.

## Por que vários arquivos?
O projeto foi dividido intencionalmente para ficar navegável no GitHub.
O GitHub recomenda manter objetos Git pequenos (máximo recomendado de 1 MB; limite rígido de 100 MB) e, em diffs, um único arquivo não deve passar de 20.000 linhas ou 500 KB. A divisão abaixo mantém os arquivos de código bem menores que esses limites.

## Conteúdo
- 30 trilhas de estudo
- 3.000 lições executáveis
- 35 minigames
- XP, níveis, moedas e streak
- conquistas
- loja
- missão diária
- persistência de progresso
- exportação de relatório
- laboratório de algoritmos
- banco de desafios
- self-test automático

## Arquivos
- `MegaProjetoJava.java` — entrada e interface principal
- `StudyEngine.java` — academia
- `LessonRegistry.java` — catálogo
- `LessonPack01A.java` ... `LessonPack05B.java` — 3.000 lições (300 por arquivo)
- `Arcade.java` — 35 minigames
- `AlgorithmLab.java` — laboratório técnico
- `ChallengeBank.java` — desafios
- `PlayerProfile.java` — progresso
- `SaveSystem.java` — salvamento
- `ProfileUI.java`, `ShopUI.java`, `DailyMission.java` — sistemas auxiliares
- `TestSuite.java` — validações

## NetBeans
1. Abra seu projeto Java.
2. Copie todos os `.java` para o mesmo source root/pacote utilizado pelo seu projeto.
3. Defina `MegaProjetoJava` como classe principal, caso queira usar esta versão como aplicação principal.
4. Compile e execute.

## Terminal
```bash
javac *.java
java MegaProjetoJava
```

Para verificar a compilação/lógica básica sem abrir a interface interativa:
```bash
java MegaProjetoJava --test
```

## Git
Depois de substituir os arquivos no seu projeto:
```bash
git add .
git commit -m "Mega Projeto Java V3 | Estudos + 35 Minigames | Código dividido para GitHub"
git push
```

Não são necessários arquivos externos nem bibliotecas de terceiros.
