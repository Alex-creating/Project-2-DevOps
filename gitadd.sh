#!/bin/bash

echo "commit message?"
read commit

git add .
git commit -m "$commit"
git push -u origin devBranch
