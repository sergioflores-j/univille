(() => {
  const tipos = ['fifo', 'aleatorio', 'lfu'];
  tipos.forEach(tipo => {
    const parameters = init();
    execute({ tipo, ...parameters });
  })
})();

function init() {
  return {
    paginas: paginasIniciais(),
    paginasRequisitadas: [1, 2, 5, 7, 1, 4, 5, 6],
    memoriaPrincipal: [], // a memória principal tem apenas 4 espaços
    limiteMemoriaPrincipal: 4,
    memoriaVirtual: paginasIniciais(), // inicialmente todas as páginas estão na memória virtual
  };
}

function paginasIniciais() {
  return [
    { id: 1, uso: 0 },
    { id: 2, uso: 0 },
    { id: 3, uso: 0 },
    { id: 4, uso: 0 },
    { id: 5, uso: 0 },
    { id: 6, uso: 0 },
    { id: 7, uso: 0 },
  ];
}

function execute({
  paginas,
  memoriaPrincipal,
  paginasRequisitadas,
  memoriaVirtual,
  limiteMemoriaPrincipal,
  tipo,
} = {}) {
  paginas.forEach(pagina => {
    if (memoriaPrincipal.find(i => i.id === pagina)) return;

    // substitui
    if (memoriaPrincipal.length >= limiteMemoriaPrincipal) {
      let particao;

      if (tipo === 'fifo') particao = fifo();
      else if (tipo === 'aleatorio') particao = aleatorio({ paginas, pagina });
      else if (tipo === 'lfu') particao = lfu({
        paginas,
        memoriaVirtual,
        memoriaPrincipal,
        paginasRequisitadas,
        limiteMemoriaPrincipal,
      });
    } else {
      // a loca
      memoriaPrincipal.push(pagina);
    }
  });
}

function fifo() {
  return 0;
}

function aleatorio({ limiteMemoriaPrincipal } = {}) {
  return Math.floor((Math.random() * limiteMemoriaPrincipal) + 1);
}

function lfu({ paginas, memoriaVirtual, memoriaPrincipal, paginasRequisitadas, limiteMemoriaPrincipal, } = {}) {
  
}