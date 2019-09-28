(() => {
  const algoritmos = ['fifo', 'aleatorio', 'lfu'];
  algoritmos.forEach(algoritmo => {
    const paginas = [
      { id: 1, contador: 1 },
      { id: 2, contador: 1 },
      { id: 3, contador: 1 },
      { id: 4, contador: 1 },
      { id: 5, contador: 1 },
      { id: 6, contador: 1 },
      { id: 7, contador: 1 },
    ];

    const variaveis = {
      paginas: [...paginas],
      memoriaPrincipal: [],
      tamanhoMemoriaPrincipal: 4, // a memória principal tem apenas 4 espaços
      fila: [1, 2, 5, 7, 1, 4, 5, 6, 1, 4, 2],
    };

    executar({ algoritmo, ...variaveis });
  })
})();

function executar({
  algoritmo,
  paginas,
  memoriaPrincipal,
  fila,
  tamanhoMemoriaPrincipal,
} = {}) {
  console.log('-----------------------------');
  console.log('Executando o algoritmo:', algoritmo);
  console.log();

  let pageFaults = 0;
  fila.forEach(idPagina => {
    const paginaNaMemoria = memoriaPrincipal.find(i => i.id === idPagina);
    if (paginaNaMemoria) {
      paginaNaMemoria.contador++;
      return;
    }

    const pagina = paginas.find(p => p.id === idPagina);

    let particao;

    // procura uma posição para ser substituida
    if (memoriaPrincipal.length >= tamanhoMemoriaPrincipal) {
      if (algoritmo === 'fifo') {
        particao = fifo();
      } else if (algoritmo === 'aleatorio') {
        particao = aleatorio({ tamanhoMemoriaPrincipal });
      } else if (algoritmo === 'lfu') {
        particao = lfu({ memoriaPrincipal });
      }

      console.log('Page fault! Removendo a página:', memoriaPrincipal[particao], '- Alocando a página:', pagina);
      // substitui
      removePagina({ memoriaPrincipal, particao });
    }

    // aloca
    inserePagina({ memoriaPrincipal, pagina });

    if (Number.isNaN(Number(particao))) console.log('Page fault! Alocando a página:', pagina);

    // Atribui ao contador de page faults
    pageFaults++;
  });

  console.log();
  console.log('Ao todo foram', pageFaults, 'page faults para este algoritmo.');
  console.log('Memória final:', memoriaPrincipal);
  console.log();
}

function inserePagina({ memoriaPrincipal = [], pagina }) {
  memoriaPrincipal.push({ ...pagina });
}

function removePagina({ memoriaPrincipal, particao }) {
  // Posição, quantidade de itens
  memoriaPrincipal.splice(particao, 1);
}

/**
 * @returns {number} a primeira posição da fila
 */
function fifo() {
  return 0;
}

/** 
 * @returns {number} uma posição aleatória
 */
function aleatorio({ tamanhoMemoriaPrincipal } = {}) {
  return Math.floor(Math.random() * tamanhoMemoriaPrincipal);
}

/**
 * @returns {number} posição do primeiro item com menor contador
 */
function lfu({ memoriaPrincipal } = {}) {
  return memoriaPrincipal.reduce((paginaMenosUsada, pagina, index) => {
    if (index === 0 || pagina.contador < paginaMenosUsada.contador) return { ...pagina, index };

    return paginaMenosUsada;
  }, {}).index;
}