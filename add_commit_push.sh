if [ $# -eq 0 ]
  then
    echo "No commit message supplied!"
    exit
fi
git add .
git commit -m "$1" 
git push origin HEAD:main
