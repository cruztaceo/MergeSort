#Merge Sort

**Input:** array A of n distinct integers

**Output:** array with the same integers, sort from smallest to largest.

---

```
// ignoring base cases
C := recursively sort first half of A
D := recursively sort second half of A
return Merge(C,D)
```

---
#Merge

**Input:** sorted arrays C and D (length *n/2* each)

**Output:** sorted array B (length *n*)

**Simplifying assumption:** n is even

---

```
i := 1
j := 1
for k := 1 to n do
    if C[i] < D[j] then
        B[k] := C[i]        //populate output array
        i := i + 1          //increment i
    else                    //D[j] < C[i]
        B[k] := D[j]
        j := j + 1
```