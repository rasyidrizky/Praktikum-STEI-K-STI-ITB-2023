#include "array.h"
#include "boolean.h"
#include <stdio.h>

void MakeEmpty(TabInt *T) {
    (*T).Neff = 0;
}

int NbElmt(TabInt T) {
    return T.Neff;
}

int MaxNbEl(TabInt T) {
    return IdxMax - IdxMin + 1;
}

IdxType GetFirstIdx(TabInt T) {
    return IdxMin;
}

IdxType GetLastIdx(TabInt T) {
    return NbElmt(T);
}

ElType GetElmt(TabInt T, IdxType i) {
    return T.TI[i - IdxMin];
}

void SetTab(TabInt Tin, TabInt *Tout) {
    *Tout = Tin;
}

void SetEl(TabInt *T, IdxType i, ElType v) {
    (*T).TI[i - IdxMin] = v;
    if (i > (*T).Neff) {
        (*T).Neff = i;
    }
}

void SetNeff(TabInt *T, IdxType N) {
    (*T).Neff = N;
}

boolean IsIdxValid(TabInt T, IdxType i) {
    return (i >= IdxMin && i <= IdxMax);
}

boolean IsIdxEff(TabInt T, IdxType i) {
    return (i >= GetFirstIdx(T) && i <= GetLastIdx(T));
}

boolean IsEmpty(TabInt T) {
    return (NbElmt(T) == 0);
}

boolean IsFull(TabInt T) {
    return (NbElmt(T) == MaxNbEl(T));
}

void TulisIsi(TabInt T) {
    if (IsEmpty(T)) {
        printf("Tabel kosong\n");
    } else {
        for (int i = GetFirstIdx(T); i <= GetLastIdx(T); i++) {
            printf("%d:%d\n", i - IdxMin, GetElmt(T, i));
        }
    }
}

TabInt PlusTab(TabInt T1, TabInt T2) {
    TabInt T;
    MakeEmpty(&T);
    for (int i = GetFirstIdx(T1); i <= GetLastIdx(T1); i++) {
        SetEl(&T, i, GetElmt(T1, i) + GetElmt(T2, i));
    }
    return T;
}

TabInt MinusTab(TabInt T1, TabInt T2) {
    TabInt T;
    MakeEmpty(&T);
    for (int i = GetFirstIdx(T1); i <= GetLastIdx(T1); i++) {
        SetEl(&T, i, GetElmt(T1, i) - GetElmt(T2, i));
    }
    return T;
}

ElType ValMax(TabInt T) {
    ElType max = GetElmt(T, GetFirstIdx(T));
    for (int i = GetFirstIdx(T) + 1; i <= GetLastIdx(T); i++) {
        if (GetElmt(T, i) > max) {
            max = GetElmt(T, i);
        }
    }
    return max;
}

ElType ValMin(TabInt T) {
    ElType min = GetElmt(T, GetFirstIdx(T));
    for (int i = GetFirstIdx(T) + 1; i <= GetLastIdx(T); i++) {
        if (GetElmt(T, i) < min) {
            min = GetElmt(T, i);
        }
    }
    return min;
}

IdxType IdxMaxTab(TabInt T) {
    IdxType idx = GetFirstIdx(T);
    ElType max = GetElmt(T, idx);
    for (int i = GetFirstIdx(T) + 1; i <= GetLastIdx(T); i++) {
        if (GetElmt(T, i) > max) {
            max = GetElmt(T, i);
            idx = i;
        }
    }
    return idx;
}

IdxType IdxMinTab(TabInt T) {
    IdxType idx = GetFirstIdx(T);
    ElType min = GetElmt(T, idx);
    for (int i = GetFirstIdx(T) + 1; i <= GetLastIdx(T); i++) {
        if (GetElmt(T, i) < min) {
            min = GetElmt(T, i);
            idx = i;
        }
    }
    return idx;
}